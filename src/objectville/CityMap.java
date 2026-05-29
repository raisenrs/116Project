package objectville;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class CityMap {
    Cell[][] grid;
    int rows;
    int cols;

    ArrayList<Zone> zones = new ArrayList<Zone>();
    ArrayList<UtilityProvider> utilities = new ArrayList<UtilityProvider>();
    ArrayList<ServiceBuilding> services = new ArrayList<ServiceBuilding>();

    public CityMap(String filename) {
        loadMap(filename);
    }

    private void loadMap(String filename) {
        try {
            ArrayList<String[]> satirlar = new ArrayList<String[]>();
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String satir;

            while ((satir = reader.readLine()) != null) {
                satir = satir.trim();
                if (satir.equals("")) continue;

                String[] parcalar;
                if (satir.contains(" ") || satir.contains(",")) {
                    parcalar = satir.split("[\\s,]+");
                } else {
                    parcalar = new String[satir.length()];
                    for (int i = 0; i < satir.length(); i++) {
                        parcalar[i] = String.valueOf(satir.charAt(i));
                    }
                }
                satirlar.add(parcalar);
            }
            reader.close();

            if (satirlar.isEmpty()) {
                System.out.println("Map dosyasi bos!");
                System.exit(0);
            }

            this.rows = satirlar.size();
            this.cols = satirlar.get(0).length;
            this.grid = new Cell[this.rows][this.cols];

            for (int r = 0; r < this.rows; r++) {
                for (int c = 0; c < this.cols; c++) {
                    char ch = satirlar.get(r)[c].charAt(0);
                    Cell cell = makeCell(ch, r, c);
                    this.grid[r][c] = cell;

                    if (cell instanceof Zone)
                        zones.add((Zone) cell);
                    else if (cell instanceof UtilityProvider)
                        utilities.add((UtilityProvider) cell);
                     else if (cell instanceof ServiceBuilding)
                        services.add((ServiceBuilding) cell);
                }
            }

        } catch (Exception e) {
            System.out.println("Dosya okunurken hata cikti: " + e.getMessage());
        }
    }

    private Cell makeCell(char ch, int r, int c) {
        if (ch == 'H') return new HousingZone(r, c);
        if (ch == 'I') return new IndustrialZone(r, c);
        if (ch == 'C') return new CommercialZone(r, c);
        if (ch == 'P') return new PowerPlant(r, c);
        if (ch == 'W') return new WaterStation(r, c);
        if (ch == 'T') return new InternetHub(r, c);
        if (ch == 'D') return new Hospital(r, c);
        if (ch == 'R') return new RoadCell(r, c);
        if (ch == 'E') return new EmptyCell(r, c);
        throw new SE116ConfigurationException("Bilinmeyen karakter: " + ch);
    }
}

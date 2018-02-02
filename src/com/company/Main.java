package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {

    public static final int VEIKSMAS_01 = 1;
    public static final int VEIKSMAS_02 = 2;
    public static final int VEIKSMAS_03 = 3;
    public static final int VEIKSMAS_04 = 4;
    public static final int VEIKSMAS_05 = 5;
    public static final int VEIKSMAS_END = 0;

    public static void main(String[] args) {
        Main objektas = new Main();
        objektas.vykdytiProgramaBeGalo();
    }

    private String _failoVardas = "duomenys.txt";
    private FileReader _in;
    private BufferedReader _bufferis;
    private Scanner _sc;
    private FileWriter _out;
    private int _n;


    public void atidarytiFaila() {
        try {
            _in = new FileReader(_failoVardas);
            _bufferis = new BufferedReader(_in);
        } catch (Exception e) {

        }
    }

    public void skaitymasIsFailo() {
        try {
            String eilute = _bufferis.readLine();
            while (eilute != null) {
                String[] zodziai = eilute.split("\\|");
                for (int i = 0; i < zodziai.length; i++) {
                    System.out.print(zodziai[i] + " ");
                }
                System.out.println();
                eilute = _bufferis.readLine();
            }
            _bufferis.close();
            _in.close();
        } catch (Exception e) {

        }
    }

    public void akiuTikrinimas() {
        System.out.print("Iveskite akiu spalva: ");
        Scanner _sc = new Scanner(System.in);
        String spalva = _sc.nextLine();
        try {
            String eilute = _bufferis.readLine();
            while (eilute != null) {
                String[] zodziai = eilute.split("\\|");
                if (zodziai[3].equals(spalva)) {
                    System.out.println(zodziai[0]);
                }
                eilute = _bufferis.readLine();
            }
            _bufferis.close();
            _in.close();
        } catch (Exception e) {

        }
    }
  /*  public String[] zodziai2;
    public void aukciausiasZmogus() {
        int did = 0;
        int eil = 0;

        try {
            String eilute = _bufferis.readLine();
            while (eilute != null) {
                String[] zodziai = eilute.split("\\|");
                zodziai2[eil]=zodziai[2];
                eil++;
                eilute = _bufferis.readLine();
            }
            int[] ugiai = new int[eil];
            for (int i = 0; i < eil; i++) {
                ugiai[i] = Integer.parseInt(zodziai2[2]);
            }

            for (int i=0; i<eil; i++){
                if (ugiai[i]>ugiai[did]){
                    did=i;
                }
            }
            for (int i = 0; i < eil; i++) {
                if (ugiai[i]==ugiai[did]) {
                    System.out.println(zodziai2[0]);
                }
            }
            _bufferis.close();
            _in.close();

        } catch (Exception e) {
        }

    }*/

    public void irasymasIFaila() {
        _sc = new Scanner(System.in);
        System.out.println("Iveskite tokiu formatu: \nVardas|Amžius(m)|Ūgis(cm)|Akių Spalva(žodis)");

        String tekstas = _sc.nextLine();
        try {
            _out = new FileWriter(_failoVardas, true);
            _out.write(tekstas);
            _out.write('\n');
            _out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void trinimasIsFailo() {
        try {
            _out = new FileWriter(_failoVardas);
            String tekstas = "";
            _out.write(tekstas);
            _out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

 /*   public void deleteFileContent (int eilutesNumeris){
        String[] eilutes = new String[gaukFailoEiluciuKieki[]];

        try {
            for (int i=0; ; i<eilutes.length; i++){
                eilutes[i] = _bufferis.readLine();
            }
            _bufferis
                    _out = new FileWriter(_failoVardas);
            _out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public void Pasirinkimai() {
        System.out.println("=================================================");
        System.out.println("Pasirinkite veiksma: ");
        System.out.println(VEIKSMAS_01 + " - Parodytu visus įrašus iš failo lentelėje ");
        System.out.println(VEIKSMAS_02 + " - Pridėti naujus įrašus į failą ");
        System.out.println(VEIKSMAS_03 + " - Trinti įrašus iš failo ");
        System.out.println(VEIKSMAS_04 + " - Rasti visus žmones su nurodyta akių spalva ");
        System.out.println(VEIKSMAS_05 + " - Rasti aukščiausią žmogų iš sąrašo ");
        System.out.println(VEIKSMAS_END + " - Isjungti programa ");
        System.out.println("=================================================");
    }

    public void vykdytiProgramaBeGalo() {
        boolean kartoti = true;
        Scanner sc = new Scanner(System.in);
        while (kartoti == true) {
            Pasirinkimai();
            int veiksmas = sc.nextInt();
            atidarytiFaila();
            switch (veiksmas) {
                case VEIKSMAS_END:
                    kartoti = false;
                    break;
                case VEIKSMAS_01:
                    skaitymasIsFailo();
                    break;
                case VEIKSMAS_02:
                    irasymasIFaila();
                    break;
                case VEIKSMAS_03:
                    trinimasIsFailo();
                    break;
                case VEIKSMAS_04:
                    akiuTikrinimas();
                    break;
                case VEIKSMAS_05:
                    // aukciausiasZmogus();
                    break;
            }
        }
    }
}

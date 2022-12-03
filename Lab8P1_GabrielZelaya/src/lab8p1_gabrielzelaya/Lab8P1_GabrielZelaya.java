package lab8p1_gabrielzelaya;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab8P1_GabrielZelaya {
    
    public static void menu(){
        Scanner entrada = new Scanner(System.in);
        int menu;
        do{
            System.out.println("----------Menú----------");
            System.out.println("(1)Pocket Monsters\n(2)DC vs Marvel\n(3)Salir");
            menu = entrada.nextInt();
            switch (menu){
                case 1 -> ejercicio1();
                case 2 -> {
                }
                case 3 -> {
                }
                default -> System.out.println("Número no es válido");
            }
        } while(menu != 3);
        if (menu == 3) {
            System.out.println("Saliendo del menú");
        }
    }
    
    public static void ejercicio1(){
        System.out.println("-----Jugador1-----");
        ArrayList<Pokemon> lista1 = new ArrayList();
        jugador1(lista1);
        System.out.println("-----Jugador2-----");
        ArrayList<Pokemon> lista2 = new ArrayList();
        jugador2(lista2); 
        
        int numRonda = 1;
        boolean perder = true;
        int suerte1 = lista1.get(0).getLuck();
        int suerte2 = lista2.get(0).getLuck();
        do {
            System.out.println("-----Ronda" + numRonda + "-----");           
            if (suerte1 > suerte2) {
                System.out.println(lista1.get(0).getNombre() + " ataca primero: " + lista1.get(0).getHp() + " puntos de vida");
                System.out.println(lista2.get(0).getNombre() + " ataca segundo: " + lista2.get(0).getHp() + " puntos de vida");
                System.out.println("**Puntos Restantes**");
                lista1.get(0).setHp(lista1.get(0).getHp() - lista2.get(0).getDmg());
                lista2.get(0).setHp(lista2.get(0).getHp() - lista1.get(0).getDmg());
                System.out.println(lista1.get(0).getNombre() + " tiene " + lista1.get(0).getHp() + " restantes");
                System.out.println(lista2.get(0).getNombre() + " tiene " + lista2.get(0).getHp() + " restantes");
                if (lista1.get(0).getHp() <= 0) {
                    lista1.remove(0);
                    suerte1 = lista1.get(0).getLuck();
                } else if (lista2.get(0).getHp() <= 0) {
                    lista2.remove(0);
                    suerte2 = lista2.get(0).getLuck();
                }
            } else {
                System.out.println(lista2.get(0).getNombre() + " ataca primero: " + lista2.get(0).getHp() + " puntos de vida");
                System.out.println(lista1.get(0).getNombre() + " ataca segundo: " + lista1.get(0).getHp() + " puntos de vida");
                System.out.println("**Puntos Restantes**");
                lista2.get(0).setHp(lista2.get(0).getHp() - lista1.get(0).getDmg());
                lista1.get(0).setHp(lista1.get(0).getHp() - lista2.get(0).getDmg());
                System.out.println(lista2.get(0).getNombre() + " tiene " + lista2.get(0).getHp() + " restantes");
                System.out.println(lista1.get(0).getNombre() + " tiene " + lista1.get(0).getHp() + " restantes");
                if (lista2.get(0).getHp() <= 0) {
                    lista2.remove(0);
                    suerte2 = lista2.get(0).getLuck();
                } else if (lista1.get(0).getHp() <= 0) {
                    lista1.remove(0);
                    suerte1 = lista1.get(0).getLuck();
                }
            }
            if (lista1.isEmpty()) {
                System.out.println("-----RESULTADO-----");
                System.out.println(lista2.get(0).getNombre() + " ES EL GANADOR");
                perder = false;
            } else if(lista2.isEmpty()) {
                System.out.println("-----RESULTADO-----");
                System.out.println(lista1.get(0).getNombre() + " ES EL GANADOR");
                perder = false;
            }
            numRonda++;
        } while (perder == true);
        lista1.removeAll(lista1);
        lista2.removeAll(lista2); 

    }
    
    
    public static void jugador1(ArrayList lista){
        Scanner entrada = new Scanner(System.in);
        int numPokemon = 1;
        String nombre;
        int hp;
        int dmg;  
        boolean crearPokemon = true;
        
        do {
            switch (numPokemon){
                case 1 -> {
                    System.out.println("Ingrese el nombre del " + numPokemon + " pokemón:");
                    nombre = entrada.nextLine();
                    entrada = new Scanner(System.in);
                    System.out.println("Ingrese la vida del " + numPokemon + " pokemón:");
                    hp = entrada.nextInt();
                    System.out.println("Ingrese el daño del " + numPokemon + " pokemón:");
                    dmg = entrada.nextInt();
                    Pokemon pok1 = new Pokemon(nombre,hp,dmg);
                    lista.add(pok1);
                }
                case 2 -> {
                    System.out.println("Ingrese el nombre del " + numPokemon + " pokemón:");
                    nombre = entrada.nextLine();
                    entrada = new Scanner(System.in);
                    System.out.println("Ingrese la vida del " + numPokemon + " pokemón:");
                    hp = entrada.nextInt();
                    System.out.println("Ingrese el daño del " + numPokemon + " pokemón:");
                    dmg = entrada.nextInt();
                    Pokemon pok2 = new Pokemon(nombre,hp,dmg);
                    lista.add(pok2);
                }
                case 3 -> {
                    System.out.println("Ingrese el nombre del " + numPokemon + " pokemón:");
                    nombre = entrada.nextLine();
                    entrada = new Scanner(System.in);
                    System.out.println("Ingrese la vida del " + numPokemon + " pokemón:");
                    hp = entrada.nextInt();
                    System.out.println("Ingrese el daño del " + numPokemon + " pokemón:");
                    dmg = entrada.nextInt();
                    Pokemon pok3 = new Pokemon(nombre,hp,dmg);
                    lista.add(pok3);
                    break;
                }
            }
            if (numPokemon != 3){
                System.out.println("¿Desea agregar otro pokemón? s/n");
                String agregar = entrada.next();
                entrada = new Scanner(System.in);
                if (agregar.equals("s") || agregar.equals("S")) {
                    numPokemon++;
                } else {
                    crearPokemon = false;
                }
            }

        } while (crearPokemon == true);
    }
    
    public static void jugador2(ArrayList lista){
        Scanner entrada = new Scanner(System.in);
        int numPokemon = 1;
        String nombre;
        int hp;
        int dmg;  
        boolean crearPokemon = true;
        
        do {
            switch (numPokemon){
                case 1 -> {
                    System.out.println("Ingrese el nombre del " + numPokemon + " pokemón:");
                    nombre = entrada.nextLine();
                    entrada = new Scanner(System.in);
                    System.out.println("Ingrese la vida del " + numPokemon + " pokemón:");
                    hp = entrada.nextInt();
                    System.out.println("Ingrese el daño del " + numPokemon + " pokemón:");
                    dmg = entrada.nextInt();
                    Pokemon pok1 = new Pokemon(nombre,hp,dmg);
                    lista.add(pok1);
                }
                case 2 -> {
                    System.out.println("Ingrese el nombre del " + numPokemon + " pokemón:");
                    nombre = entrada.nextLine();
                    entrada = new Scanner(System.in);
                    System.out.println("Ingrese la vida del " + numPokemon + " pokemón:");
                    hp = entrada.nextInt();
                    System.out.println("Ingrese el daño del " + numPokemon + " pokemón:");
                    dmg = entrada.nextInt();
                    Pokemon pok2 = new Pokemon(nombre,hp,dmg);
                    lista.add(pok2);
                }
                case 3 -> {
                    System.out.println("Ingrese el nombre del " + numPokemon + " pokemón:");
                    nombre = entrada.nextLine();
                    entrada = new Scanner(System.in);
                    System.out.println("Ingrese la vida del " + numPokemon + " pokemón:");
                    hp = entrada.nextInt();
                    System.out.println("Ingrese el daño del " + numPokemon + " pokemón:");
                    dmg = entrada.nextInt();
                    Pokemon pok3 = new Pokemon(nombre,hp,dmg);
                    lista.add(pok3);
                    break;
                }
            }
            if (numPokemon != 3){
                System.out.println("¿Desea agregar otro pokemón? s/n");
                String agregar = entrada.next();
                entrada = new Scanner(System.in);
                if (agregar.equals("s") || agregar.equals("S")) {
                    numPokemon++;
                } else {
                    crearPokemon = false;
                }
            }
        } while (crearPokemon == true);
    }

    public static void main(String[] args) {
        menu();
    }
    
}

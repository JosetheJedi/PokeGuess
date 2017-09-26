package com.example.josef.pokeguess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Josef on 9/21/2017.
 */

public class PokemonDataProvider {
    public static List<Pokemon> pokemonList;
    public static Map<String, Pokemon> pokemonMap;

    static {
        pokemonList = new ArrayList<>();
        pokemonMap = new HashMap<>();

        addPokemon(new Pokemon("001", "Bulbasaur", "sound001", "p001", "s001", "Grass"));
        addPokemon(new Pokemon("002", "Ivysaur", "sound002", "p002", "s002", "Grass"));
        addPokemon(new Pokemon("003", "Venusaur", "sound003", "p003", "s003", "Grass"));
        addPokemon(new Pokemon("004", "Charmander", "sound004", "p004", "s004", "Fire"));
        addPokemon(new Pokemon("005", "Charmeleon", "sound005", "p005", "s005", "Fire"));
        addPokemon(new Pokemon("006", "Charizard", "sound006", "p006", "s006", "Fire"));
        addPokemon(new Pokemon("007", "Squirtle", "sound007", "p007", "s007", "Water"));
        addPokemon(new Pokemon("008", "Wartortle", "sound008", "p008", "s008", "Water"));
        addPokemon(new Pokemon("009", "Blastoise", "sound009", "p009", "s009", "Water"));
        addPokemon(new Pokemon("010", "Caterpie", "sound010", "p010", "s010", "Bug"));
        addPokemon(new Pokemon("011", "Metapod", "sound011", "p011", "s011", "Bug"));
        addPokemon(new Pokemon("012", "Butterfree", "sound012", "p012", "s012", "Bug"));
        addPokemon(new Pokemon("013", "Weedle", "sound013", "p013", "s013", "Bug"));
        addPokemon(new Pokemon("014", "Kakuna", "sound014", "p014", "s014", "Bug"));
        addPokemon(new Pokemon("015", "Beedrill", "sound015", "p015", "s015", "Bug"));
        addPokemon(new Pokemon("016", "Pidgey", "sound016", "p016", "s016", "Normal"));
        addPokemon(new Pokemon("017", "Pidgeotto", "sound017", "p017", "s017", "Normal"));
        addPokemon(new Pokemon("018", "Pidgeot", "sound018", "p018", "s018", "Normal"));
        addPokemon(new Pokemon("019", "Rattata", "sound019", "p019", "s019", "Normal"));
        addPokemon(new Pokemon("020", "Raticate", "sound020", "p020", "s020", "Normal"));
        addPokemon(new Pokemon("021", "Spearow", "sound021", "p021", "s021", "Normal"));
        addPokemon(new Pokemon("022", "Fearow", "sound022", "p022", "s022", "Normal"));
        addPokemon(new Pokemon("023", "Ekans", "sound023", "p023", "s023", "Poison"));
        addPokemon(new Pokemon("024", "Arbok", "sound024", "p024", "s024", "Poison"));
        addPokemon(new Pokemon("025", "Pikachu", "sound025", "p025", "s025", "Electric"));
        addPokemon(new Pokemon("026", "Raichu", "sound026", "p026", "s026", "Electric"));
        addPokemon(new Pokemon("027", "Sandshrew", "sound027", "p027", "s027", "Ground"));
        addPokemon(new Pokemon("028", "Sandslash", "sound028", "p028", "s028", "Ground"));
        addPokemon(new Pokemon("029", "Nidoran?", "sound029", "p029", "s029", "Poison"));
        addPokemon(new Pokemon("030", "Nidorina", "sound030", "p030", "s030", "Poison"));
        addPokemon(new Pokemon("031", "Nidoqueen", "sound031", "p031", "s031", "Poison"));
        addPokemon(new Pokemon("032", "Nidoran?", "sound032", "p032", "s032", "Poison"));
        addPokemon(new Pokemon("033", "Nidorino", "sound033", "p033", "s033", "Poison"));
        addPokemon(new Pokemon("034", "Nidoking", "sound034", "p034", "s034", "Poison"));
        addPokemon(new Pokemon("035", "Clefairy", "sound035", "p035", "s035", "Normal"));
        addPokemon(new Pokemon("036", "Clefable", "sound036", "p036", "s036", "Normal"));
        addPokemon(new Pokemon("037", "Vulpix", "sound037", "p037", "s037", "Fire"));
        addPokemon(new Pokemon("038", "Ninetales", "sound038", "p038", "s038", "Fire"));
        addPokemon(new Pokemon("039", "Jigglypuff", "sound039", "p039", "s039", "Normal"));
        addPokemon(new Pokemon("040", "Wigglytuff", "sound040", "p040", "s040", "Normal"));
        addPokemon(new Pokemon("041", "Zubat", "sound041", "p041", "s041", "Poison"));
        addPokemon(new Pokemon("042", "Golbat", "sound042", "p042", "s042", "Poison"));
        addPokemon(new Pokemon("043", "Oddish", "sound043", "p043", "s043", "Grass"));
        addPokemon(new Pokemon("044", "Gloom", "sound044", "p044", "s044", "Grass"));
        addPokemon(new Pokemon("045", "Vileplume", "sound045", "p045", "s045", "Grass"));
        addPokemon(new Pokemon("046", "Paras", "sound046", "p046", "s046", "Bug"));
        addPokemon(new Pokemon("047", "Parasect", "sound047", "p047", "s047", "Bug"));
        addPokemon(new Pokemon("048", "Venonat", "sound048", "p048", "s048", "Bug"));
        addPokemon(new Pokemon("049", "Venomoth", "sound049", "p049", "s049", "Bug"));
        addPokemon(new Pokemon("050", "Diglett", "sound050", "p050", "s050", "Ground"));
        addPokemon(new Pokemon("051", "Dugtrio", "sound051", "p051", "s051", "Ground"));
        addPokemon(new Pokemon("052", "Meowth", "sound052", "p052", "s052", "Normal"));
        addPokemon(new Pokemon("053", "Persian", "sound053", "p053", "s053", "Normal"));
        addPokemon(new Pokemon("054", "Psyduck", "sound054", "p054", "s054", "Water"));
        addPokemon(new Pokemon("055", "Golduck", "sound055", "p055", "s055", "Water"));
        addPokemon(new Pokemon("056", "Mankey", "sound056", "p056", "s056", "Fighting"));
        addPokemon(new Pokemon("057", "Primeape", "sound057", "p057", "s057", "Fighting"));
        addPokemon(new Pokemon("058", "Growlithe", "sound058", "p058", "s058", "Fire"));
        addPokemon(new Pokemon("059", "Arcanine", "sound059", "p059", "s059", "Fire"));
        addPokemon(new Pokemon("060", "Poliwag", "sound060", "p060", "s060", "Water"));
        addPokemon(new Pokemon("061", "Poliwhirl", "sound061", "p061", "s061", "Water"));
        addPokemon(new Pokemon("062", "Poliwrath", "sound062", "p062", "s062", "Water"));
        addPokemon(new Pokemon("063", "Abra", "sound063", "p063", "s063", "Psychic"));
        addPokemon(new Pokemon("064", "Kadabra", "sound064", "p064", "s064", "Psychic"));
        addPokemon(new Pokemon("065", "Alakazam", "sound065", "p065", "s065", "Psychic"));
        addPokemon(new Pokemon("066", "Machop", "sound066", "p066", "s066", "Fighting"));
        addPokemon(new Pokemon("067", "Machoke", "sound067", "p067", "s067", "Fighting"));
        addPokemon(new Pokemon("068", "Machamp", "sound068", "p068", "s068", "Fighting"));
        addPokemon(new Pokemon("069", "Bellsprout", "sound069", "p069", "s069", "Grass"));
        addPokemon(new Pokemon("070", "Weepinbell", "sound070", "p070", "s070", "Grass"));
        addPokemon(new Pokemon("071", "Victreebel", "sound071", "p071", "s071", "Grass"));
        addPokemon(new Pokemon("072", "Tentacool", "sound072", "p072", "s072", "Water"));
        addPokemon(new Pokemon("073", "Tentacruel", "sound073", "p073", "s073", "Water"));
        addPokemon(new Pokemon("074", "Geodude", "sound074", "p074", "s074", "Rock"));
        addPokemon(new Pokemon("075", "Graveler", "sound075", "p075", "s075", "Rock"));
        addPokemon(new Pokemon("076", "Golem", "sound076", "p076", "s076", "Rock"));
        addPokemon(new Pokemon("077", "Ponyta", "sound077", "p077", "s077", "Fire"));
        addPokemon(new Pokemon("078", "Rapidash", "sound078", "p078", "s078", "Fire"));
        addPokemon(new Pokemon("079", "Slowpoke", "sound079", "p079", "s079", "Water"));
        addPokemon(new Pokemon("080", "Slowbro", "sound080", "p080", "s080", "Water"));
        addPokemon(new Pokemon("081", "Magnemite", "sound081", "p081", "s081", "Electric"));
        addPokemon(new Pokemon("082", "Magneton", "sound082", "p082", "s082", "Electric"));
        addPokemon(new Pokemon("083", "Farfetch'd", "sound083", "p083", "s083", "Normal"));
        addPokemon(new Pokemon("084", "Doduo", "sound084", "p084", "s084", "Normal"));
        addPokemon(new Pokemon("085", "Dodrio", "sound085", "p085", "s085", "Normal"));
        addPokemon(new Pokemon("086", "Seel", "sound086", "p086", "s086", "Water"));
        addPokemon(new Pokemon("087", "Dewgong", "sound087", "p087", "s087", "Water"));
        addPokemon(new Pokemon("088", "Grimer", "sound088", "p088", "s088", "Poison"));
        addPokemon(new Pokemon("089", "Muk", "sound089", "p089", "s089", "Poison"));
        addPokemon(new Pokemon("090", "Shellder", "sound090", "p090", "s090", "Water"));
        addPokemon(new Pokemon("091", "Cloyster", "sound091", "p091", "s091", "Water"));
        addPokemon(new Pokemon("092", "Gastly", "sound092", "p092", "s092", "Ghost"));
        addPokemon(new Pokemon("093", "Haunter", "sound093", "p093", "s093", "Ghost"));
        addPokemon(new Pokemon("094", "Gengar", "sound094", "p094", "s094", "Ghost"));
        addPokemon(new Pokemon("095", "Onix", "sound095", "p095", "s095", "Rock"));
        addPokemon(new Pokemon("096", "Drowzee", "sound096", "p096", "s096", "Psychic"));
        addPokemon(new Pokemon("097", "Hypno", "sound097", "p097", "s097", "Psychic"));
        addPokemon(new Pokemon("098", "Krabby", "sound098", "p098", "s098", "Water"));
        addPokemon(new Pokemon("099", "Kingler", "sound099", "p099", "s099", "Water"));
        addPokemon(new Pokemon("100", "Voltorb", "sound100", "p100", "s100", "Electric"));
        addPokemon(new Pokemon("101", "Electrode", "sound101", "p101", "s101", "Electric"));
        addPokemon(new Pokemon("102", "Exeggcute", "sound102", "p102", "s102", "Grass"));
        addPokemon(new Pokemon("103", "Exeggutor", "sound103", "p103", "s103", "Grass"));
        addPokemon(new Pokemon("104", "Cubone", "sound104", "p104", "s104", "Ground"));
        addPokemon(new Pokemon("105", "Marowak", "sound105", "p105", "s105", "Ground"));
        addPokemon(new Pokemon("106", "Hitmonlee", "sound106", "p106", "s106", "Fighting"));
        addPokemon(new Pokemon("107", "Hitmonchan", "sound107", "p107", "s107", "Fighting"));
        addPokemon(new Pokemon("108", "Lickitung", "sound108", "p108", "s108", "Normal"));
        addPokemon(new Pokemon("109", "Koffing", "sound109", "p109", "s109", "Poison"));
        addPokemon(new Pokemon("110", "Weezing", "sound110", "p110", "s110", "Poison"));
        addPokemon(new Pokemon("111", "Rhyhorn", "sound111", "p111", "s111", "Ground"));
        addPokemon(new Pokemon("112", "Rhydon", "sound112", "p112", "s112", "Ground"));
        addPokemon(new Pokemon("113", "Chansey", "sound113", "p113", "s113", "Normal"));
        addPokemon(new Pokemon("114", "Tangela", "sound114", "p114", "s114", "Grass"));
        addPokemon(new Pokemon("115", "Kangaskhan", "sound115", "p115", "s115", "Normal"));
        addPokemon(new Pokemon("116", "Horsea", "sound116", "p116", "s116", "Water"));
        addPokemon(new Pokemon("117", "Seadra", "sound117", "p117", "s117", "Water"));
        addPokemon(new Pokemon("118", "Goldeen", "sound118", "p118", "s118", "Water"));
        addPokemon(new Pokemon("119", "Seaking", "sound119", "p119", "s119", "Water"));
        addPokemon(new Pokemon("120", "Staryu", "sound120", "p120", "s120", "Water"));
        addPokemon(new Pokemon("121", "Starmie", "sound121", "p121", "s121", "Water"));
        addPokemon(new Pokemon("122", "Mr.", "sound122", "p122", "s122", "Mime"));
        addPokemon(new Pokemon("123", "Scyther", "sound123", "p123", "s123", "Bug"));
        addPokemon(new Pokemon("124", "Jynx", "sound124", "p124", "s124", "Ice"));
        addPokemon(new Pokemon("125", "Electabuzz", "sound125", "p125", "s125", "Electric"));
        addPokemon(new Pokemon("126", "Magmar", "sound126", "p126", "s126", "Fire"));
        addPokemon(new Pokemon("127", "Pinsir", "sound127", "p127", "s127", "Bug"));
        addPokemon(new Pokemon("128", "Tauros", "sound128", "p128", "s128", "Normal"));
        addPokemon(new Pokemon("129", "Magikarp", "sound129", "p129", "s129", "Water"));
        addPokemon(new Pokemon("130", "Gyarados", "sound130", "p130", "s130", "Water"));
        addPokemon(new Pokemon("131", "Lapras", "sound131", "p131", "s131", "Water"));
        addPokemon(new Pokemon("132", "Ditto", "sound132", "p132", "s132", "Normal"));
        addPokemon(new Pokemon("133", "Eevee", "sound133", "p133", "s133", "Normal"));
        addPokemon(new Pokemon("134", "Vaporeon", "sound134", "p134", "s134", "Water"));
        addPokemon(new Pokemon("135", "Jolteon", "sound135", "p135", "s135", "Electric"));
        addPokemon(new Pokemon("136", "Flareon", "sound136", "p136", "s136", "Fire"));
        addPokemon(new Pokemon("137", "Porygon", "sound137", "p137", "s137", "Normal"));
        addPokemon(new Pokemon("138", "Omanyte", "sound138", "p138", "s138", "Rock"));
        addPokemon(new Pokemon("139", "Omastar", "sound139", "p139", "s139", "Rock"));
        addPokemon(new Pokemon("140", "Kabuto", "sound140", "p140", "s140", "Rock"));
        addPokemon(new Pokemon("141", "Kabutops", "sound141", "p141", "s141", "Rock"));
        addPokemon(new Pokemon("142", "Aerodactyl", "sound142", "p142", "s142", "Rock"));
        addPokemon(new Pokemon("143", "Snorlax", "sound143", "p143", "s143", "Normal"));
        addPokemon(new Pokemon("144", "Articuno", "sound144", "p144", "s144", "Ice"));
        addPokemon(new Pokemon("145", "Zapdos", "sound145", "p145", "s145", "Electric"));
        addPokemon(new Pokemon("146", "Moltres", "sound146", "p146", "s146", "Fire"));
        addPokemon(new Pokemon("147", "Dratini", "sound147", "p147", "s147", "Dragon"));
        addPokemon(new Pokemon("148", "Dragonair", "sound148", "p148", "s148", "Dragon"));
        addPokemon(new Pokemon("149", "Dragonite", "sound149", "p149", "s149", "Dragon"));
        addPokemon(new Pokemon("150", "Mewtwo", "sound150", "p150", "s150", "Psychic"));
        addPokemon(new Pokemon("151", "Mew", "sound151", "p151", "s151", "Psychic"));


    }

    private static void addPokemon(Pokemon p){
        pokemonList.add(p);
        pokemonMap.put(p.getID(), p);
    }
}

package pl.akademiakodu.lotto.model;

import java.util.Random;

public class LoremIpsum {

    // an example paragraph
    public String standard = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor " +
            "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco " +
            "laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit " +
            "esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui " +
            "officia deserunt mollit anim id est laborum.";

    // a collection of words to be printed out

    public static String[] words = {"a", "ac", "accumsan", "ad", "adipiscing",
            "aenean", "aliquam", "aliquet", "amet", "ante", "aptent", "arcu",
            "at", "auctor", "augue", "bibendum", "blandit", "class", "commodo",
            "condimentum", "congue", "consectetur", "consequat", "conubia",
            "convallis", "cras", "cubilia", "cum", "curabitur", "curae",
            "cursus", "dapibus", "diam", "dictum", "dictumst", "dignissim",
            "dis", "dolor", "donec", "dui", "duis", "egestas", "eget",
            "eleifend", "elementum", "elit", "enim", "erat", "eros", "est",
            "et", "etiam", "eu", "euismod", "facilisi", "facilisis", "fames",
            "faucibus", "felis", "fermentum", "feugiat", "fringilla", "fusce",
            "gravida", "habitant", "habitasse", "hac", "hendrerit",
            "himenaeos", "iaculis", "id", "imperdiet", "in", "inceptos",
            "integer", "interdum", "ipsum", "justo", "lacinia", "lacus",
            "laoreet", "lectus", "leo", "libero", "ligula", "litora",
            "lobortis", "lorem", "luctus", "maecenas", "magna", "magnis",
            "malesuada", "massa", "mattis", "mauris", "metus", "mi",
            "molestie", "mollis", "montes", "morbi", "mus", "nam", "nascetur",
            "natoque", "nec", "neque", "netus", "nibh", "nisi", "nisl", "non",
            "nostra", "nulla", "nullam", "nunc", "odio", "orci", "ornare",
            "parturient", "pellentesque", "penatibus", "per", "pharetra",
            "phasellus", "placerat", "platea", "porta", "porttitor", "posuere",
            "potenti", "praesent", "pretium", "primis", "proin", "pulvinar",
            "purus", "quam", "quis", "quisque", "rhoncus", "ridiculus",
            "risus", "rutrum", "sagittis", "sapien", "scelerisque", "sed",
            "sem", "semper", "senectus", "sit", "sociis", "sociosqu",
            "sodales", "sollicitudin", "suscipit", "suspendisse", "taciti",
            "tellus", "tempor", "tempus", "tincidunt", "torquent", "tortor",
            "tristique", "turpis", "ullamcorper", "ultrices", "ultricies",
            "urna", "ut", "varius", "vehicula", "vel", "velit", "venenatis",
            "vestibulum", "vitae", "vivamus", "viverra", "volutpat",
            "vulputate"};

    // examples of punctuation
    private static final String[] punctuation = {".", "?","!"};

    private static Random random = new Random();

    public LoremIpsum() {
    }

    // I STAGE - WORD generation - draws a word from the words array

    public static String drawWord() {
        return words[random.nextInt(words.length - 1)];
    }

    // draws a punctuation mark from the punctuation table

    public static String drawPunctuation() {
        return punctuation[random.nextInt(punctuation.length - 1)];
    }


    // OPTION where is the number of words we want to be printed out

    public static String words(int count) {
        StringBuilder s = new StringBuilder();
        while (count-- > 0)
            s.append(drawWord()).append(" ");
        return s.toString().trim();
    }

    // II STAGE - generating sentences

public static String sentenceFragment() {
        return words(random.nextInt(10) + 3);
    } // choose within 10 numbers, min amounts is 3 and max 13

     // making sentences from words

    public static String sentence() {
    // first word - the first word of the sentence begins with a capital letter
        String w = drawWord();
    // my object is: the first letter with a capital letter + the remaining part of the word at + "" at the end :)
        StringBuilder s = new StringBuilder(w.substring(0, 1).toUpperCase()).append(w.substring(1)).append(" ");
        //
        if (random.nextBoolean()) {
            int r = random.nextInt(3) + 1;
            for (int i = 0; i < r; i++)
                s.append(sentenceFragment()).append(", ");
        }
    // last fragment + punctuation - dot at the end
        return s.append(sentenceFragment()).append(drawPunctuation()).append(" ")
                .toString();
    }


    // OPTION where is the number of sentences we want to be printed out

    public static String sentences(int count) {
        StringBuilder s = new StringBuilder();
        while (count-- > 0)
            s.append(sentence());
        return s.toString().trim();
    }

    // III STAGE - generating paragraphs

    // making paragraph from sentences

    public static String paragraph() {
        // first word - "    "
        // my object is: fist word + sentences. Min 20 + enter
       // String enter = System.getProperty("line.separator");
        //StringBuilder p = new StringBuilder(" LOREN IPSUM ").append(sentences(20)).append("\n");
        StringBuilder p = new StringBuilder("").append(sentences(20));
        return p.toString();
    }

    // OPTION where is the number of sentences we want to be printed out

    public static String paragraphsHtml(int count) {
        StringBuilder p = new StringBuilder("<p>");
        for (int i = 0; i < count; i++) {
            p.append(paragraph());

            if (i < count - 1) {
                p.append("</p><p>");
            }
        }
        p.append("</p>");

        return p.toString();
    }

    // here we dont have new Line in HTML
    public static String paragraphs(int count) {
        StringBuilder p = new StringBuilder();
        String enter1 = System.getProperty("line.separator");
        while (count-- > 0)
            p.append(paragraph()).append(enter1);
        return p.toString();
    }
}


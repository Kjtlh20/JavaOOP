/* Реализуйте программу, которая сопоставит каждой букве ее представление в виде ASCII - art,
 * Ваша программа должна дать возможность вывода произвольного текста на экран в виде его ASCII-art представления.
 */
package com.gmail.dev.surovtsev.yaroslav;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String line1 = " #  ##   ## ##  ### ###  ## # # ###  ## # # #   # # ###  #  ##   #  ##   ## ### # # # # # # # # # # ### ### ";
        String line2 = "# # # # #   # # #   #   #   # #  #    # # # #   ### # # # # # # # # # # #    #  # # # # # # # # # #   #   # ";
        String line3 = "### ##  #   # # ##  ##  # # ###  #    # ##  #   ### # # # # ##  # # ##   #   #  # # # # ###  #   #   #   ## ";
        String line4 = "# # # # #   # # #   #   # # # #  #  # # # # #   # # # # # # #    ## # #   #  #  # # # # ### # #  #  #       ";
        String line5 = "# # ##   ## ##  ### #    ## # # ###  #  # # ### # # # #  #  #     # # # ##   #  ###  #  # # # #  #  ###  #  ";
        List<String> ASCIIArt = new ArrayList<>();
        ASCIIArt.add(line1);
        ASCIIArt.add(line2);
        ASCIIArt.add(line3);
        ASCIIArt.add(line4);
        ASCIIArt.add(line5);
        int width = 4;
        int height = 5;
        String text = "Hello Java 11";
        text = text.toLowerCase();
        ASCIIArtPrinter asciiArtPrinter = new ASCIIArtPrinter(text, width, height, ASCIIArt);
        asciiArtPrinter.printText();
    }
}

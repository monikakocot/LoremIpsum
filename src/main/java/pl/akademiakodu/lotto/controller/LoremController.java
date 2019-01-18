package pl.akademiakodu.lotto.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.akademiakodu.lotto.model.LoremIpsum;

@Controller
public class LoremController {

    @GetMapping("/form")
    public String form() {
        return "form";
    }

    @GetMapping("/result")
    public String index(@RequestParam("count") int count,
                        @RequestParam("choice") String choice,
                        ModelMap modelMap) {

        if (count != 0 && choice.equals("word")) {

            modelMap.addAttribute("word",LoremIpsum.words(count));
            return "words";

        } else if (count != 0 && choice.equals("sentence")) {

            modelMap.addAttribute("sentence",LoremIpsum.sentences(count));
            return "sentences";

        } else if (count != 0 && choice.equals("paragraph")) {

            modelMap.addAttribute("paragraph",LoremIpsum.paragraphsHtml(count));
            return "paragraphs";
        }
            return null;
    }
}
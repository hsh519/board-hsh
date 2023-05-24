package idusw.springboot.controller;

import idusw.springboot.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/boards")
public class BoardController {

    private BoardService boardService;

    @GetMapping("")
    public String getBoardList(Model model) {
        model.addAttribute("key", "value");
        return "/board/list";
    }
}

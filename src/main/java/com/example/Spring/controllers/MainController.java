package com.example.Spring.controllers;

import com.example.Spring.models.Comment;
import com.example.Spring.models.Post;
import com.example.Spring.models.User;
import com.example.Spring.repositories.CommentRepo;
import com.example.Spring.repositories.PostRepo;
import com.example.Spring.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@RequestMapping("/posts")
@Controller
public class MainController {
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @GetMapping("/")
    public String main(Model model){ // принимаем параметр (шаблон)
        Iterable<Post> posts = postRepo.findAll(); // находим все посты из бд
        model.addAttribute("posts", posts); // добавляем их на страницу
        return "main"; // выводим страницу с постами
    }
    @GetMapping("/add")
    public String addingPostView(){
        return "add"; // перенаправляем на страницу добавления поста
    }
    @PostMapping("/add")
    public String addingPost(@RequestParam String title, @RequestParam String anons,
                             @RequestParam String text){ // принимаем параметры (название, анонс и текст поста)
        Post post = new Post(title,anons,text,LocalDate.now()); // создание объекта поста
        postRepo.save(post); // сохраняем пост в бд
        return "redirect:/posts/"; // перенаправляем на главную страницу
    }
    @GetMapping("/{id}")
    public String postView(@PathVariable Long id, Model model) { // принимаем параметры (id поста и шаблон)
        Post post = postRepo.findById(id).orElse(null); // создаём объект поста с указанным id (если пост с таким id не найден в бд, пост равен null)
        if (post != null) { // если пост всё же найден
            model.addAttribute("post", post); // добавляем его на страницу
            List<Comment> comments = commentRepo.findByPost(post); // находим комментарии к этому посту
            if (comments != null) { // если комментарии к посту есть
                model.addAttribute("comments", comments); // добавляем их на страницу
            }
            return "post"; // возращаем страницу поста
        }else { // если же поста с таким id нет (пост равен null)
            return "pageNotFound"; // возвращаем страницу с ошибкой
        }
    }

    @PostMapping("/{id}")
    public String leaveComment(@PathVariable Long id, @RequestParam String name, @RequestParam String email,
                               @RequestParam String text){ // принимаем параметры (id и текст поста, имя и email пользователя)
        Comment comment = new Comment(name,text,email,LocalDate.now(),postRepo.findById(id).orElse(null)); // создаём объект комментария к посту
        User user = new User(name,email); // создаём объект пользователя
        commentRepo.save(comment); // сохраняем коммент в бд
        if (jdbcTemplate.queryForObject(
                "SELECT count(*) FROM users WHERE user_name = ? and user_email = ?",
                Integer.class, name, email) == 0){ // если пользователя с такими же данными в бд нет
            userRepo.save(user); // сохраняем нового пользователя
        }
        return "redirect:/posts/{id}"; // перенаправляем на страницу с постом
    }
}

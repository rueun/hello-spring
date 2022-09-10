package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello"; // resources/templates/"리턴값".html
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name")String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    // 이걸 쓸 일은 거의 없다 밑에 것이 진짜
    @GetMapping("hello-string")
    @ResponseBody // http 응답 body에 내가 직접 데이터를 넣어주겠다
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; // "hello spring", 문자가 오면 그냥 문자 자체를 넘김(HttpMessageConverter의 StringHttpMessageConverter가 동작)
    }

    
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name); // value 값 설정
        return hello; // 객체가 오면 기본적으로 스프링에서 JSON 방식으로 만든 다음에 반환(HttpMessageConverter의 JSONConverter가 동작. 객체로 JSON으로 바꾸는 Jackson 라이브러리 사용)
    }

    // 프로퍼티 접근 방식
    // name 변수가 private이기 때문에 외부에서 바로 접근 불가능해서 getter, setter를 사용하여 접근
    static class Hello {
        private String name; // 키 값

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }




}

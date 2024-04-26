package org.zerock.b01.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.zerock.b01.dto.Member;
import org.zerock.b01.dto.ReplyDTO;
import org.zerock.b01.service.ReplyService;

import javax.validation.Valid;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/replies")
@Log4j2
@RequiredArgsConstructor
public class ReplyController {

//    @GetMapping(value = "/testGet")
//    public void testGet() {
//        log.info("testGet");
//    }
//
//    @GetMapping(value = "/testGet2")
//    public int testGet2(int num1) {
//        log.info("testGet2");
//        return num1;
//    }
//
//    @PostMapping(value = "/test")
//    public void test() {
//        log.info("test");
//    }
//
//    @PostMapping(value = "/test2")
//    public void test2(int num1) {
//        log.info(num1);
//    }
//
//    @PostMapping(value = "/test3")
//    public void test3(@RequestBody Member member) {
//        log.info(member);
//    }
//
//    @PostMapping(value = "/test4")
//    public Map<String, Member> test4(@RequestBody Member member) {
//        Map<String, Member> map = new HashMap<>();
//        log.info(member);
//        map.put("member", member);
//        return map;
//    }
//
//    @PostMapping(value = "/test4_1", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public Map<String, Member> test4_1(@RequestBody Member member) {
//        Map<String, Member> map = new HashMap<>();
//        log.info(member);
//        map.put("member", member);
//        return map;
//    }

//    @ApiOperation(value = "Replies POST", notes = "POST 방식으로 댓글 등록")
//    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
//    // 해당 메소드를 받아서 소비(consumes)하는 데이터가 어떤 종류인지 명시.
//    public Map<String, Long> register(@RequestBody ReplyDTO replyDTO) {
//        //@RequestBody는 JSON 문자열을 ReplyDTO로 변환하는 역할.
//        Map<String, Long> map = new HashMap<>();
//        map.put("replyDTO", replyDTO.getBno());
//
//        log.info("replyDTO : " + replyDTO);
//        return map;
//    }

    private final ReplyService replyService;

    @ApiOperation(value = "Replies POST", notes = "POST 방식으로 댓글 등록")
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,Long> register(
            @Valid @RequestBody ReplyDTO replyDTO,
            BindingResult bindingResult)throws BindException{

        log.info(replyDTO);

        if(bindingResult.hasErrors()){
            throw new BindException(bindingResult);
        }

        Map<String, Long> resultMap = new HashMap<>();

        Long rno = replyService.register(replyDTO);

        resultMap.put("rno",rno);

        return resultMap;
    }


}

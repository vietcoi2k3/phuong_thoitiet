package com.example.weatheradvice.controller;

import com.example.weatheradvice.entity.AdviceEntity;
import com.example.weatheradvice.entity.CodeEntity;
import com.example.weatheradvice.repository.AdviceRepository;
import com.example.weatheradvice.repository.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class AdviceController {

    @Autowired
    private AdviceRepository adviceRepository;

    @Autowired
    private CodeRepository codeRepository;

    @RequestMapping(value = "get-all-advice",method = RequestMethod.GET)
    public ResponseEntity getAllAdvice(){
        return ResponseEntity.ok(adviceRepository.findAll());
    }

    @RequestMapping(value = "get-advice-by-code", method = RequestMethod.POST)
    public ResponseEntity getAdviceByCode(@RequestParam String code) {
        List<CodeEntity> codeEntities = codeRepository.findByCode(code);

        if (codeEntities.isEmpty()) {
            // Trả về lỗi hoặc thông báo không tìm thấy mã
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Code not found");
        }

        CodeEntity codeEntity = codeEntities.get(0);

        Optional<AdviceEntity> adviceEntityOptional = adviceRepository.findById(codeEntity.getAdviceEntityId());

        if (adviceEntityOptional.isPresent()) {
            AdviceEntity adviceEntity = adviceEntityOptional.get();
            System.out.println("**************");

            return ResponseEntity.ok(adviceEntity);
        } else {
            // Trả về lỗi hoặc thông báo không tìm thấy AdviceEntity
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Advice not found");
        }
    }

}

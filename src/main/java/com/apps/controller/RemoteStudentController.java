package com.apps.controller;

import com.apps.common.ApiResponse;
import com.apps.dto.StudentDto;
import com.apps.service.StudentClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/remote-students")
@RequiredArgsConstructor
public class RemoteStudentController {

    private final StudentClientService studentClientService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentDto>> getRemoteStudent(@PathVariable("id") Long id) {
        StudentDto dto = studentClientService.getStudent(id);

        ApiResponse<StudentDto> response = ApiResponse.<StudentDto>builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.OK.value())
                .message("Remote Student Data fetched successfully")
                .data(dto)
                .path("/api/remote-students/" + id)
                .build();

        return ResponseEntity.ok(response);
    }
}

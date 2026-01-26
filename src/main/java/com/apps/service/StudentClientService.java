package com.apps.service;

import com.apps.common.ApiResponse;
import com.apps.dto.StudentDto;
import com.apps.exception.StudentNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentClientService {

    private final RestClient restClient;

    public StudentDto getStudent(Long id) {

        ApiResponse<StudentDto> response =
                restClient.get()
                        .uri("/api/students/search/{id}", id)
                        .retrieve()
                        .body(new ParameterizedTypeReference<>() {
                        });

        if (response == null || response.getData() == null) {
            throw new StudentNotFoundException("Student not found");
        }

        log.info("response = {}", response);
        return response.getData();
    }
}

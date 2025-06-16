package com.latinhouse.backend.lesson.adapter.in.web;

import com.latinhouse.backend.lesson.adapter.in.web.request.AddLessonWebRequest;
import com.latinhouse.backend.lesson.adapter.in.web.request.UpdateLessonWebRequest;
import com.latinhouse.backend.lesson.adapter.in.web.response.LessonWebResponse;
import com.latinhouse.backend.lesson.port.in.AddLessonUseCase;
import com.latinhouse.backend.lesson.port.in.FindLessonUseCase;
import com.latinhouse.backend.lesson.port.in.UpdateLessonUseCase;
import com.latinhouse.backend.lesson.port.in.request.AddLessonAppRequest;
import com.latinhouse.backend.lesson.port.in.request.UpdateLessonAppRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/lesson")
@Tag(name = "Lesson", description = "Lesson API Document")
@RequiredArgsConstructor
public class ApiV1LessonController {

    private final AddLessonUseCase addLessonUseCase;
    private final FindLessonUseCase findLessonUseCase;
    private final UpdateLessonUseCase updateLessonUseCase;

    @PostMapping
    @Operation(summary = "Add Lesson", description = "Add Lesson")
    public ResponseEntity<LessonWebResponse> add(@Valid @RequestBody AddLessonWebRequest webReq) {

        AddLessonAppRequest appReq = AddLessonAppRequest.from(webReq);
        LessonWebResponse response = new LessonWebResponse(addLessonUseCase.add(appReq));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find Lesson", description = "Find Lesson")
    public ResponseEntity<LessonWebResponse> findById(@RequestParam("id") String id) {

        LessonWebResponse response = new LessonWebResponse(findLessonUseCase.findById(id));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping()
    @Operation(summary = "Find Lessons", description = "Find Lessons")
    public ResponseEntity<List<LessonWebResponse>> findAll() {

        List<LessonWebResponse> response = findLessonUseCase.findAll().stream()
                .map(LessonWebResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Lesson", description = "Update Lesson")
    public ResponseEntity<LessonWebResponse> update(@RequestParam("id") String id, @Valid @RequestBody UpdateLessonWebRequest webReq) {

        UpdateLessonAppRequest appReq = UpdateLessonAppRequest.builder()
                .content(webReq.getContent())
                .build();
        LessonWebResponse response = new LessonWebResponse(updateLessonUseCase.update(id, appReq));

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}

package com.latinhouse.backend.profile.adapter.in.web;

import com.latinhouse.backend.profile.adapter.in.web.request.AddProfileWebRequest;
import com.latinhouse.backend.profile.adapter.in.web.request.UpdateProfileWebRequest;
import com.latinhouse.backend.profile.adapter.in.web.response.ProfileWebResponse;
import com.latinhouse.backend.profile.port.in.AddProfileUseCase;
import com.latinhouse.backend.profile.port.in.FindProfileUseCase;
import com.latinhouse.backend.profile.port.in.UpdateProfileUseCase;
import com.latinhouse.backend.profile.port.in.request.AddProfileAppRequest;
import com.latinhouse.backend.profile.port.in.request.UpdateProfileAppRequest;
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
@RequestMapping("/api/v1/profile")
@Tag(name = "Profile", description = "Profile API Document")
@RequiredArgsConstructor
public class ApiV1ProfileController {

    private final AddProfileUseCase addProfileUseCase;
    private final FindProfileUseCase findProfileUseCase;
    private final UpdateProfileUseCase updateProfileUseCase;

    @PostMapping
    @Operation(summary = "Add Profile", description = "Add Profile")
    public ResponseEntity<ProfileWebResponse> add(@Valid @RequestBody AddProfileWebRequest webReq) {

        AddProfileAppRequest appReq = AddProfileAppRequest.builder()
                .id(webReq.getId())
                .content(webReq.getContent())
                .build();
        ProfileWebResponse response = new ProfileWebResponse(addProfileUseCase.add(appReq));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find Profile", description = "Find Profile")
    public ResponseEntity<ProfileWebResponse> findById(@RequestParam("id") String id) {

        ProfileWebResponse response = new ProfileWebResponse(findProfileUseCase.findById(id));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping()
    @Operation(summary = "Find Profiles", description = "Find Profiles")
    public ResponseEntity<List<ProfileWebResponse>> findAll() {

        List<ProfileWebResponse> response = findProfileUseCase.findAll().stream()
                .map(ProfileWebResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Profile", description = "Update Profile")
    public ResponseEntity<ProfileWebResponse> update(@RequestParam("id") String id, @Valid @RequestBody UpdateProfileWebRequest webReq) {

        UpdateProfileAppRequest appReq = UpdateProfileAppRequest.builder()
                .content(webReq.getContent())
                .build();
        ProfileWebResponse response = new ProfileWebResponse(updateProfileUseCase.update(id, appReq));

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}

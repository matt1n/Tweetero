package com.tweetero.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TweetDTO {
    @NotBlank 
    private String text;

    @NotNull
    private Long userId;
}

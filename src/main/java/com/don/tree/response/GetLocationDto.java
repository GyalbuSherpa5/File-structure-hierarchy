package com.don.tree.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetLocationDto {
    private String parentDirectory;
    private String targetDirectory;
}

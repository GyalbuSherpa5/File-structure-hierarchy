package com.don.tree.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChildToSaveDto {
    private String directory;
    private String folderName;
}

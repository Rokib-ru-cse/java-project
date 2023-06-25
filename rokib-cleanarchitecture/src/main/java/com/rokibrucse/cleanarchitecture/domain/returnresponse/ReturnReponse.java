package com.rokibrucse.cleanarchitecture.domain.returnresponse;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReturnReponse<T> {
    private String message;
    private boolean succeeded;
    private List<T> values;
    private T value;
}

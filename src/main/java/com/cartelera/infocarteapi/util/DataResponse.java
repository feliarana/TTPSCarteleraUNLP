package com.cartelera.infocarteapi.util;

import com.cartelera.infocarteapi.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class DataResponse {

  private Boolean success;
  private Integer count;
  private List data;

}
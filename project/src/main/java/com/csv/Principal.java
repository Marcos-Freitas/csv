package com.csv;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.csv.CsvUtils.CsvUtil;

public class Principal 
{
    Path arquivo = Paths.get("funcionarios.csv");
    CsvUtil.gerarCSVFuncSemFilhos(arquivo);
}

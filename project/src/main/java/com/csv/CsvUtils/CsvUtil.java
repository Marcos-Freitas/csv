package com.csv.CsvUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import com.csv.Funcionario.Funcionario;

public class CsvUtil {
    public static void gerarCSVFuncSemFilhos(Path arquivo) {
        List<Funcionario> func = leCsv(arquivo);

        gerarCsvNovo("func_filtrado.csv",func);//passando lista de funcionarios

        func.forEach((f) -> {
            System.out.println("Id: " + f.getId() + "Filhos: " + f.getNumFihos());
        });
        
    }

    //LEITURA

    private static void gerarCsvNovo(String string, List<Funcionario> func) {
        String cabecalho = "ID, Filhos, Salario\n";

        Path arquivoFinal = Paths.get(nomeArquivo);

        try {
            Files.writeString(arquivoFinal, cabecalho);

            StringBuilder builder - new StringBuilder(); 

            //tirar quem nao tem filho, nao precisamos no projeto livro
            //esta filtrando só pega que tem filho, quem nao tem sera filtrado
            func.stream().filter((f) -> f.getNumFihos()!=0).forEach((f)-> {
                builder.append(f.getId() + ",");
                builder.append(f.getNumFihos() + ",");
                builder.append(f.getSalario() + "\n");
        
            });

            Files.writeString(arquivoFinal, builder.toString(), StandardOpenOption.APPEND);

        } catch (IOException e) {
            //TODO: handle exception
            e.printStackTrace();
        }

        Files.writeString(arquivoFinal, cabecalho);
    }

    private static List<Funcionario> leCsv (Path arquivo){
        List<Funcionario> funconarios = new ArrayList<>();
        try {
            List<String> linhas = Files.readAllLines(arquivo);//Ler linha por linha do csv e colocar em uma lista
            linhas.remove(o);
            //para cada linha criar um funcionario
            linhas.forEach((linha) -> {
             String[] linhaSplit = linha.split(", ");  
             Funcionario = func = new Funcionario(Integer.parseInt(linhaSplit[0]), 
                                                    Integer.parseInt(linhaSplit[3]), 
                                                    Double.parseDouble(linhaSplit[4]); 
            funconarios.add(func);
            };
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return funconarios;
    }
}

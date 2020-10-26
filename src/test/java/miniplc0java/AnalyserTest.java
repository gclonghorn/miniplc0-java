package miniplc0java;

import miniplc0java.analyser.Analyser;
import miniplc0java.instruction.Instruction;
import org.junit.Test;
import miniplc0java.tokenizer.StringIter;
import miniplc0java.tokenizer.Token;
import miniplc0java.tokenizer.TokenType;
import miniplc0java.tokenizer.Tokenizer;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnalyserTest {
    @Test
    public void testq() {
        String classpath=this.getClass().getResource("/").getPath();
        System.out.println(classpath);
        InputStream input;
        try {
            input = new FileInputStream("F:\\编译\\miniplc0\\src\\hello.plc0");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        }
        Scanner scanner;
        scanner = new Scanner(input);
        var iter = new StringIter(scanner);
        var tokenizer = new Tokenizer(iter);
        var analyzer = new Analyser(tokenizer);
        List<Instruction> instructions;
        try {
            instructions = analyzer.analyse();
        } catch (Exception e) {
            // 遇到错误不输出，直接退出
            System.err.println(e);
            System.exit(0);
            return;
        }
        for (Instruction instruction : instructions) {
            System.out.println(instruction.toString());
        }

    }
}

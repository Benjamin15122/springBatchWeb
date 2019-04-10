package cn.edu.nju.demos.pipefilter;
import org.springframework.batch.item.ItemWriter;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.*;
import java.util.*;

public class MyWriter implements ItemWriter<Report>{
    
    @Override
    public void write(List<? extends Report> reports) throws Exception{
//        Output output = new Output(new FileOutputStream("classpath:bin/outputs/report.bin"));
//        Kryo kryo = new Kryo();
//        kryo.setRegistrationRequired(false);
//        kryo.writeObject(output, reports);
//        output.close();
        /* Test if file was correctly written*/
        // Input input = new Input(new FileInputStream("bin/outputs/report.bin"));
        // List<? extends Report> reArray = kryo.readObject(input, ArrayList.class);
        // System.out.println(reArray);
        // input.close();
    }
}
package org.example;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Properties appProps = loadProperties.loadProperties("diagpod.properties");

        Map<String, String> output = new HashMap<>();

        output.put("title", String.format("Diagnostic pod v%s", appProps.getProperty("DIAGPOD_VERSION")));
        output.put("run_as", process.running_as());
        output.put("env", process.env());

        ObjectMapper objectMapper = new ObjectMapper();
        String jacksonData = null;
        try {
            jacksonData = objectMapper.writeValueAsString(output);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        System.out.println(jacksonData);

//        output_dict['run_as']=process.running_as()
//        output_dict['env']=process.env()
//        output_dict['metadata']=metadata.test(config.METADATA_IP, config.METADATA_FLAVOUR)
//        output_dict['external_connectivity']=external_connectivity.test()
//        output_dict['internal_connectivity']=internal_connectivity.test(config.METADATA_FLAVOUR)
//        result=json.dumps(output_dict, indent = 3)
//        print(result)

    }
}
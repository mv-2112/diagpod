package org.example;

import org.json.JSONObject;

import java.util.Properties;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Properties appProps = loadProperties.loadProperties("diagpod.properties");

        JSONObject output = new JSONObject();

        output.put("title", String.format("Diagnostic pod v%s", appProps.getProperty("DIAGPOD_VERSION")));
        output.put("run_as", process.running_as());
        output.put("env", process.env());

        metadata.test_ip("192.168.68.1");

        System.out.println(output);

//        output_dict['run_as']=process.running_as()
//        output_dict['env']=process.env()
//        output_dict['metadata']=metadata.test(config.METADATA_IP, config.METADATA_FLAVOUR)
//        output_dict['external_connectivity']=external_connectivity.test()
//        output_dict['internal_connectivity']=internal_connectivity.test(config.METADATA_FLAVOUR)
//        result=json.dumps(output_dict, indent = 3)
//        print(result)

    }
}
import process
import config
import json
import metadata
import external_connectivity
import internal_connectivity

# print('{')

# print(f'"Title": "Diagnostic pod v{config.DIAGPOD_VERSION}"')

# output = json.dumps(process.running_as(), indent = 3)
# print(f'"running_as": {output},')

# output = json.dumps(process.env(), indent = 3)
# print(f'"env_vars": {output}')

# print('}')

output_dict = {}
output_dict['title']=f"Diagnostic pod v{config.DIAGPOD_VERSION}"
output_dict['run_as']=process.running_as()
output_dict['env']=process.env()
output_dict['metadata']=metadata.test(config.METADATA_IP, config.METADATA_FLAVOUR)
output_dict['external_connectivity']=external_connectivity.test()
output_dict['internal_connectivity']=internal_connectivity.test(config.METADATA_FLAVOUR)
result=json.dumps(output_dict, indent = 3)
print(result)

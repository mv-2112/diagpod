import network_utils

external_addresses_check=['google.com', 'azure.com', 'oracle.com']


def test():

    external_connectivity={}

    for each_address in external_addresses_check:
        r=network_utils.endpoint_lookup(each_address)
        external_connectivity[each_address]=r
    
    return external_connectivity

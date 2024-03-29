import network_utils

internal_addresses_check={}
internal_addresses_check['google']=[ '169.254.169.254', 'compute.googleapis.com' ]
internal_addresses_check['azure']=[ '169.254.169.254', 'management.azure.com' ]
internal_addresses_check['aws']=[ '169.254.169.254', 'ec2.amazonaws.com' ]
internal_addresses_check['oracle']= [ '169.254.169.254' ]
internal_addresses_check['openstack']= [ '169.254.169.254' ]


def test(flavour):

    internal_connectivity={}

    # Construct a list from all flavours
    if flavour == 'auto':
        internal_addresses_check['auto'] = []
        for each_key in internal_addresses_check.keys():
            internal_addresses_check['auto'] += internal_addresses_check[each_key]

        # De-duplicate the auto list via a set
        internal_addresses_check['auto'] = list(set(internal_addresses_check['auto']))


    for each_address in internal_addresses_check[flavour]:
        r=network_utils.endpoint_lookup(each_address)
        internal_connectivity[each_address] = r
    
    return internal_connectivity

import network_utils


def ping(address):
    r = network_utils.endpoint_ping(address)
    return r

def lookup(address):
    r = network_utils.endpoint_lookup(address)
    return r
    


def get(flavour):

    # GCP
    # http://169.254.169.254/computeMetadata/v1/ - https://hackingthe.cloud/gcp/general-knowledge/metadata_in_google_cloud_instances/

    # AWS
    # http://169.254.169.254/latest/meta-data/ - https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/instancedata-data-retrieval.html

    # Oracle
    # Looks AWS-y - https://docs.oracle.com/en-us/iaas/Content/Compute/Tasks/gettingmetadata.htm

    # Openstack and variants
    # Just hit the endpoint

    metadata_get={}
    metadata_get['flavour']=flavour
    metadata_get['content']='dummy'

    return metadata_get


def test(address, flavour):
    metadata_test = {}
    metadata_test['ping']=ping(address)
    metadata_test['lookup']=lookup(address)
    metadata_test['contents']=get(flavour)

    return metadata_test

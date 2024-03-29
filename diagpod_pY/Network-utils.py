from ping3 import ping, verbose_ping
from nslookup import Nslookup

def endpoint_lookup(address):

    lookup={}

    domain = address

    # Initialize Nslookup
    dns_query = Nslookup()
    # Alternatively, the Nslookup constructor supports optional
    # arguments for setting custom dns servers (defaults to system DNS),
    # verbosity (default: True) and using TCP instead of UDP (default: False)
    # dns_query = Nslookup(dns_servers=["1.1.1.1"], verbose=False, tcp=False)
    dns_query = Nslookup(verbose=False, tcp=False)

    ips_record = dns_query.dns_lookup(domain)

    lookup['ips_record']={ "response": ips_record.response_full, "answer": ips_record.answer }

    soa_record = dns_query.soa_lookup(domain)
    lookup['soa_record']={ "response": soa_record.response_full, "answer": soa_record.answer }

    return lookup


def endpoint_ping(address):

    endpoint_ping={}
    # v = verbose_ping(address, count=3, timeout=5)
    r = ping(address)
    if r == None:
       r='Timed out'

    # mping['verbose_ping_test']=v
    endpoint_ping[address]=r

    return endpoint_ping

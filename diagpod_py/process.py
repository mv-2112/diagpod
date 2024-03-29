import os
import pwd
import grp


def get_groupnames(user_name,gid):
    
    grouplist=[]
    for each_gid in os.getgrouplist(user_name,gid):
         grouplist.append(f"{each_gid}/{grp.getgrgid(each_gid).gr_name}")
    return grouplist
    

def running_as():

    run_as = {}
    uid = os.getuid()
    user_name=pwd.getpwuid(uid).pw_name
    gid= os.getgid()
    grouplist=get_groupnames(user_name, gid)

    run_as["uid"]=uid
    run_as["user_name"]=user_name
    run_as["gid"]=gid
    run_as["grouplist"]=grouplist

    euid = os.geteuid()
    if euid != uid:
        euser_name=pwd.getpwuid(euid).pw_name
        egid= os.getegid()
        egrouplist=get_groupnames(euser_name, egid)
        run_as["euid"]=euid
        run_as["euser_name"]=euser_name
        run_as["egid"]=egid
        run_as["egrouplist"]=egrouplist

    
    # return f"Running_as: {run_as}"
    return run_as

def env():
    env_vars = {}
    for var in os.environ:
        env_vars[var]=os.getenv(var)
    
    # return f"env_vars: {env_vars}"
    return env_vars

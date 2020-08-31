# build help tool
import os
import sys
import argparse

_script_path = sys.argv[0]
_script_dir = os.path.dirname(_script_path)
_module_names = [];
_req_module_names = [];
parser = argparse.ArgumentParser()

parser.add_argument("-m", "--module",required=False, help="need process project or module, empty will process all sub folder name as module in script folder")
parser.add_argument("-a","--action",required=False,help="1-Build&install; 2-Spring boot run; 3-Setup project structure;")
parser.add_argument("-o","--option",required=False,help="1-Generate mybatis; 2-Package as war")

args = parser.parse_args()

_module_name = args.module
_action = args.action
_option = args.option
print(_script_dir)

script_folder_files = os.listdir(os.path.abspath(_script_dir))
for _file in script_folder_files:
    if os.path.isdir(_file):
        _module_names.append(_file)

# process argument module name, special module name could be short name
if _module_name is None:
    _req_module_names=_module_names
else:
    for _name in _module_names:
        if _name.find(_module_name)!=-1:
            _req_module_names.append(_name)
            break

if _action is None:
    _action="1"

_map_cmd = {}    

for _module in _req_module_names:
    _cmd=""
    if _action=="1":
        print("")
        _cmd="mvn clean install -f {}"
    elif _action=="2":
        print("")
        _cmd="mvn clean spring-boot:run -f {}"
    elif _action=="3":
        print("")
        _cmd="mvn eclipse:clean eclipse:eclipse -f {}"
    else:
        sys.stderr.write("Error: invalid action\n")
        parser.print_help()
        sys.exit(1)
    if _option=="1":
        _cmd=_cmd+" -Dmybatis.generate.skip=false"
    elif _option=="2":
        _cmd=_cmd+" -Dpackaging.style=war"        
    # store command
    _map_cmd[_module]=_cmd.format(os.path.join(_script_dir,_module))


for key in _map_cmd:
    print("===================================================")
    print(_map_cmd[key])
    print("===================================================")
    os.system(_map_cmd[key])
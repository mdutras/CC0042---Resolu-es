from xmlrpc.server import SimpleXMLRPCServer
from xmlrpc.server import SimpleXMLRPCRequestHandler

from datetime import datetime

class RequestHandler(SimpleXMLRPCRequestHandler):
    rpc_paths = ('/RPC2',)

with SimpleXMLRPCServer(('localhost', 3333),requestHandler=RequestHandler) as server:
    server.register_introspection_functions()

    msgs = []

    def store_msg(msg):
        msgs.append(msg)
        return (True)

    def get_msgs():
        return msgs
    
    def get_IP_add():
        return "127.0.0.1"
    
    def get_datetime():
        return datetime.now().strftime("%Y-%m-%d %H:%M")
    
    server.register_function(store_msg, "store_msg")
    server.register_function(get_msgs,"get_msgs")
    server.register_function(get_IP_add,"get_IP_add")
    server.register_function(get_datetime,"get_datetime")

    server.serve_forever()
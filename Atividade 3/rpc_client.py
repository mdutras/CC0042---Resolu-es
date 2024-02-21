#Importar biblioteca
import xmlrpc.client
import socket

s = xmlrpc.client.ServerProxy('http://localhost:3333')

print(s.system.listMethods())

# Armazenar uma string na lista
s.store_msg("Pamonha")
s.store_msg("Cocada")
s.store_msg("Paçoca")
# Recuperar lista de mensagens
print(s.get_msgs())
# Retornar o IP do servidor
print(s.get_IP_add())
# Retornar data e hora do servidor no formato: YYYY-MM-DD HH:MM
print(s.get_datetime())
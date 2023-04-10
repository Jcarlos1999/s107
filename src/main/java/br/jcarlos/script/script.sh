echo "Instalando biblioteca de emails"
sudo apt-get install mailutils
echo "Terminou a instalação"
mail -s "Executando a pipe line" ${EMAIL}
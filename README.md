Back-end do sistema de Lojas.

Integrantes do trabalho:

Gustavo Marães Ferreira
Vinicius Orejana Valente
Yan Sérgio Yudi Ajiki


1 - Criar um banco de dados que será utilizado para a API se conectar;
2 - Alterar dados do arquivo application.properties, onde estão presentes os dados da conexão com o BD, como url, username e password;
3 - Na primeira execução, deixar a propriedade spring.jpa.hibernate.ddl-auto com o valor create, nas próximas execuções pode alterar para none, para não sobrescrever as tabelas já criadas.


- regra de negocio 1 -> somente administradores podem mexer com CRUD de lojas
- regra de negocio 2 -> apenas gerentes podem mexer com CRUD de estoque e frutas
- regra de negocio 3 -> frutas só podem ser pedidas se tiverem no estoque

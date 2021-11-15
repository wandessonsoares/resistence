Após executar a aplicação, a documentação da API se encontra em:
http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/


# Requisitos funcionais 

## Implementados:

- Adicionar rebelde
- Atualizar localização de um rebelde
- Reportar rebelde como traidor
- Relatorio de porcetagem de traidores 
- Relatorio de porcentagem de rebeldes 
- Pontos perdidos devido a traidores

## Não implementados:
- Relatorio de quantidade média de cada tipo de recurso por rebelde
- Negociação de recursos entre rebeldes

## Melhorias que poderiam ser feitas:
- Validações dos campos no cadastro de rebeldes
- Melhoria da funcionalidade de reportar traidor, pois da forma que está implementado não há controle
para que um rebelde indicador só possa indicar o mesmo rebelde indicado apenas uma vez


## Requisitos não funcionais:


- Utilizar Java, Spring boot, Spring Data, Hibernate(H2), Maven
- Código limpo, organizado e utilização de boas práticas
- Documentar API

**Observação**: Devido a contratempos, não devido ao tempo disponibilizado para fazer o desafio,
mas sim devido aos contratempos do dia-a-dia encontrados nesse período, não foi possível realizar os
testes unitários, bem como os requisitos funcionais não implementados e melhorias descritas acima.



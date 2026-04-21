# Ata de Reunião

**Data:** 17/04/2026  
**Horário de Início:** 19:00
**Horário de Término:** 20:30  
**Duração:** 1 Hora e 30 Minutos  
**Local:** Google Meet

## Participantes

1. Kauan Tarchetti
2. Pedro Galdino
3. Rafaela Santos
4. Arthur Brayan
5. Samuel Carvalho
6. Italo santana 
7. Tiago nepomuceno

## Participantes com faltas justificadas
1. Júlia Pêgo
2. Alan Farias
3. Marcely do Nascimento
4. Gabriel Vieira

## Resumo
A reunião definiu o direcionamento inicial do projeto MDS Turing: um sistema web para consulta, visualização e solicitação de uso de salas, laboratórios e outros espaços da FCTE/UnB, com foco em melhorar organização, disponibilidade e agendamento. Também foram discutidos o recorte do problema, os públicos-alvo, possíveis diferenciais do produto, tecnologias candidatas e a forma de organização do trabalho ao longo do semestre.

## Definição do problema e contexto
O grupo convergiu para um problema central de falta de informação sobre a disponibilidade de salas e espaços físicos dentro da faculdade, hoje consultada de forma presencial. Foi relatado que isso dificulta o planejamento de monitorias, reuniões, palestras, estudos, uso por equipes de competição, empresa júnior, docentes e outros usuários.
Foi proposto ampliar o contexto para além de salas de aula, incluindo:
● salas de estudo e convivência;
● laboratórios e espaços com equipamentos;
● auditórios e salas para palestras;
● salas de reunião para monitores, equipes e professores.
Também apareceu como necessidade complementar a consulta sobre horários de atendimento de professores, secretaria, biblioteca e outros serviços internos.

## Solução proposta
A solução proposta foi um sistema web, e não um aplicativo mobile, por ser mais viável para o grupo e por haver maior familiaridade com desenvolvimento web. A ideia principal é permitir que o usuário consulte salas disponíveis, verifique a grade de ocupação e, em alguns casos, faça solicitação de uso/reserva.
Entre as funcionalidades e ideias levantadas:
● visualização de salas, laboratórios e horários disponíveis;
● busca por critérios específicos, como horário ou tipo de espaço;
● solicitação de reserva com justificativa de uso;
● aprovação ou reprovação por perfil administrativo;
● envio de e-mail automático com confirmação da reserva;
● integração futura com agenda, como Google Agenda;
● descrição de equipamentos disponíveis em cada sala;
● auditoria dos equipamentos usados após a sessão;
● possibilidade de registrar informações a partir de imagem da tabela de horários usando OCR/visão computacional.

## Diferenciais discutidos
O grupo identificou como diferencial frente a soluções já existentes:
● atender especificamente o contexto da FCTE/UnB;
● abranger mais usos do que apenas agendamento de sala de aula;
● incluir estudo, monitoria, reunião, eventos, laboratório e convivência;
● melhorar a usabilidade com busca por critérios;
● usar um front-end moderno e mais atrativo visualmente;
● automatizar parte da atualização de dados, especialmente da grade de salas.
Foi citado um projeto semelhante da UDESC, usado como referência, mas com limitação por não contemplar o contexto da FCTE/UnB nem todos os tipos de uso discutidos.

## Públicos-alvo e papéis
Os públicos-alvo citados foram:
● alunos;
● professores / corpo docente;
● monitores;
● equipes de competição;
● empresas juniores;
● técnicos e secretaria;
● porteiros e equipe de limpeza.
Também foi discutido um modelo de perfis de acesso, em que a secretaria teria papel central de autorização para solicitações. Para a equipe, a ideia é organizar o desenvolvimento por grupos/áreas, com um responsável por acompanhar o andamento de cada frente.

## Tecnologia e arquitetura
A discussão de tecnologia apontou para um stack baseado em Java, com forte interesse em Spring/Spring Boot para o back-end. O grupo considerou que a maioria já possui alguma familiaridade com Java, o que pode reduzir a curva de aprendizado.
Tecnologias e ferramentas mencionadas:
● Java;
● Spring / Spring Boot;
● PostgreSQL ou MySQL para banco de dados;
● GitHub para acompanhamento do projeto;
● Figma para prototipação;
● visão computacional/OCR para leitura de tabelas por imagem;
● OpenCV como biblioteca possível para reconhecimento de imagem;
● IDEs como IntelliJ IDEA, Eclipse, VS Code e NetBeans foram comentadas em tom de comparação de experiência.
Também foi ressaltada a importância de padronização de nomenclatura, documentação e organização do código desde o início.

## Organização do trabalho e rotina
Como o grupo tem 12 pessoas, foi defendida a divisão em grupos menores, como duplas, trios ou áreas temáticas, com um responsável por acompanhar o progresso. A ideia é evitar que o trabalho fique concentrado em poucas pessoas e permitir melhor especialização por parte da equipe.
Sobre a rotina, foram debatidos três níveis de acompanhamento:
● atualização por WhatsApp ao longo da semana;
● reunião geral semanal;
● reuniões por área, conforme necessidade.
Também ficou claro que uma reunião fixa ajuda a evitar procrastinação e organiza melhor o ritmo de entregas. Foi mencionada a possibilidade de alinhar reuniões em horários mais viáveis para a turma, inclusive considerando encontros na aula ou logo após a aula.

## Requisitos e dados do documento
Durante a construção do documento, foram debatidos itens como:
● necessidade de saber quais salas estão disponíveis;
● dificuldade atual de consulta presencial;
● tempo perdido para localizar informações;
● custo operacional de manter a organização manual das salas;
● necessidade de permissões para solicitação e aprovação;
● informações sobre equipamentos disponíveis por sala;
● possibilidade de registrar uso de equipamentos e verificar estado ao final.
Foi citado que o documento ainda está incompleto e precisará de complementação com diagramas, pesquisa e definição mais refinada do produto.

## Decisões e próximos passos
Principais encaminhamentos definidos na reunião:
● Finalizar o documento do projeto com a definição do problema, solução, público-alvo e diferenciais.
● Pesquisar mais sobre o contexto real do problema na FCTE/UnB.
● Fazer entrevistas/pesquisa presencial com professores, porteiros, limpeza e outros usuários.
● Preparar o diagrama do produto/sistema.
● Definir a reunião semanal geral da equipe (via enquete ou no grupo).
● Organizar a equipe em grupos/áreas com responsáveis.
● Confirmar a stack tecnológica com o grupo (Java/Spring, banco e front-end).
● Conversar com o monitor para pegar referências de projetos anteriores.
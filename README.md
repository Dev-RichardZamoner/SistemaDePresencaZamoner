# SistemaDePresencaZamoner

## 1. Configuração Inicial
- **Projeto Criado no Android Studio**: Nome do projeto "SistemaDePresencaZamoner".
- **Linguagem de Programação**: Java.
- **Versão Mínima do SDK**: Definida conforme necessário.

## 2. Tela Inicial (activity_main.xml)
### Elementos Adicionados:
- **TextView** para "Marcenaria Zamoner".
- **TextView** para data e hora.
- **Botões** para navegação:
  - "Por Nome"
  - "Consultar Pontos"
  - "Entrega de EPI"
  - "Outras Opções"
  - "Administração"

### Código Java (MainActivity.java):
- Atualização automática da data e hora.
- Navegação para outras atividades ao clicar nos botões.

## 3. Atividades Criadas
### NomeActivity: Para marcar e desmarcar presença pelo nome.
- **Layout (activity_nome.xml)**: Campo de texto para nome, botões para marcar e desmarcar presença.
- **Código Java (NomeActivity.java)**: Lógica para salvar e carregar presença usando SharedPreferences.

### ConsultarPontosActivity: Para exibir registros de presença.
- **Layout (activity_consultar_pontos.xml)**: TableLayout para exibir registros, botões para exportar e limpar dados.
- **Código Java (ConsultarPontosActivity.java)**: Lógica para carregar registros de SharedPreferences, exportar para arquivo de texto e limpar dados.

### EntregaEPIActivity: Para gerenciar entrega de EPIs.
- **Layout (activity_entrega_epi.xml)**: Lista de funcionários e EPIs, CheckBox e EditText para marcar entrega e data.
- **Código Java (EntregaEPIActivity.java)**: Lógica para salvar e carregar estado dos EPIs usando SharedPreferences.

## 4. Funcionalidades Implementadas
- **Marcar e Desmarcar Presença**: Implementado na NomeActivity.
- **Exibir Registros de Presença**: Implementado na ConsultarPontosActivity.
- **Exportar e Limpar Dados**: Implementado na ConsultarPontosActivity.
- **Gerenciar Entrega de EPIs**: Implementado na EntregaEPIActivity.

## O Que Falta Fazer
### Funcionalidades Adicionais:
- **Administração**: Definir e implementar funcionalidades específicas para a atividade de administração.
- **Outras Opções**: Definir e implementar funcionalidades específicas para a atividade de outras opções.

### Melhorias e Ajustes:
- **Validação de Dados**: Adicionar validações para entrada de dados (ex.: verificar se o nome está vazio).
- **Interface de Usuário**: Melhorar a interface para torná-la mais amigável e intuitiva.
- **Testes**: Realizar testes para garantir que todas as funcionalidades estão funcionando corretamente.

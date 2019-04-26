# **Front-end Pignus**

As estruturas de pastas estão elaboradas mediante um padrão adaptado do ITCSS (Inverted Triangle CSS). Mediante isto, as pastas estão organizadas da seguinte forma:

**css:** Arquivo transpilado do SCSS,

**scss:** Pasta à ser transpilada pelo Scout APP, contendo:

- 1_settings: Configurações gerais do grid, reset de layout e afins.
- 2_tools: As variáveis, mixins e demais recursos do SCSS.
- 3_generics: Componentes genéricos (sem estilizações) para serem implementados.
- 4_components: Componentes implementados de acordo com o "3_generics" já com suas respectivas estilizações.
- 5_trumps: Arquivos de terceiros que poderemos utilizar no decorrer do desenvolvimento / aprimoramento.
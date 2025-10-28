# LaudoPro

Repositório backend do LaudoPro — aplicação para gestão de instrumentos de calibração, ordens de serviço e laudos técnicos.

Resumo
- Objetivo: fornecer API, camada de infraestrutura e modelos de domínio para gerenciar instrumentos (manômetros, válvulas de segurança, etc.), ordens de serviço (work orders), clientes, usuários e planos.
- Público-alvo: equipes técnicas que precisam controlar calibrações, registros e geração de laudos.

O que tem na solução
- `LaudoPro.API` — projeto ASP.NET Core que expõe endpoints REST para operações do sistema (autenticação, CRUD de instrumentos, ordens, relatórios, planos).
- `LaudoPro.Infrastructure` — camada de persistência: `LaudoProDbContext` (EF Core), migrations e configurações de banco.
- `LaudoPro.Domain` — modelos de domínio (POCOs), enums e regras mínimas. Aqui estão classes como `BaseModel`, `BaseInstrument`, `SafetyValve`, `PressureGauge`, `WorkOrder`, `Report`, `Plan`, `User`, `Customer`.
- `LaudoProUnitTest` — testes unitários (ex.: `UserServiceTest`) para comportamentos da aplicação.

Tecnologias e versões
- .NET 9 e .NET 8 (alguns projetos podem targetear net8.0; ver `*.csproj`).
- C# 13, Nullable enabled e ImplicitUsings em projetos que aplicam essas configurações.
- EF Core para mapeamento ORM e migrations.
- Convenções: colunas em snake_case via `[Column("...")]`, validações com `[Required]`, `[MaxLength]` e índices via `[Index]` ou Fluent API.

Como rodar localmente
1. Restaurar dependências e build:
   - `dotnet restore`
   - `dotnet build`
2. Configurar string de conexão no projeto `LaudoPro.API` (appsettings).
3. Aplicar migrations (execute a partir do projeto de infraestrutura ou usando o startup correto):
   - __Package Manager Console__: `__Add-Migration__ <Name>` e depois `__Update-Database__`
   - CLI exemplo:
     - `dotnet ef migrations add <Name> --project LaudoPro.Infrastructure --startup-project LaudoPro.API`
     - `dotnet ef database update --project LaudoPro.Infrastructure --startup-project LaudoPro.API`
4. Executar API:
   - `dotnet run --project LaudoPro.API`

Principais convenções do projeto
- Modelos são POCOs; lógica de domínio leve fica em serviços.
- `BaseModel` fornece `Uuid`, `CreatedAt` (imutável via configuração EF) e `UpdatedAt`.
- Instrumentos usam `BaseInstrument` para campos comuns (`Description`, `Tag`, `Manufacturer`, `SerialNumber`, `Model`, `Size`).
- `WorkOrder.Number` pode ser gerado no formato `WO-<8char-UUID>-<yyyyMMdd>`.
- Use `[Index(nameof(Tag), IsUnique = true)]` ou Fluent API para índices únicos e evitar duplicidade de `Tag`.

Boas práticas antes de aplicar migrações
- Verifique dados existentes que possam violar novas constraints (ex.: duplicatas em `Tag`).
- Teste migrations em ambiente de desenvolvimento antes de aplicar em produção.

Contribuição
- Siga a estrutura de pastas e convenções de nomes.
- Crie migrations no projeto `LaudoPro.Infrastructure`.
- Adicione testes unitários para novas regras de negócio.
- Faça PRs pequenos e descreva claramente a alteração.
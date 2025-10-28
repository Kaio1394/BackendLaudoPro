# LaudoPro

Reposit�rio backend do LaudoPro � aplica��o para gest�o de instrumentos de calibra��o, ordens de servi�o e laudos t�cnicos.

Resumo
- Objetivo: fornecer API, camada de infraestrutura e modelos de dom�nio para gerenciar instrumentos (man�metros, v�lvulas de seguran�a, etc.), ordens de servi�o (work orders), clientes, usu�rios e planos.
- P�blico-alvo: equipes t�cnicas que precisam controlar calibra��es, registros e gera��o de laudos.

O que tem na solu��o
- `LaudoPro.API` � projeto ASP.NET Core que exp�e endpoints REST para opera��es do sistema (autentica��o, CRUD de instrumentos, ordens, relat�rios, planos).
- `LaudoPro.Infrastructure` � camada de persist�ncia: `LaudoProDbContext` (EF Core), migrations e configura��es de banco.
- `LaudoPro.Domain` � modelos de dom�nio (POCOs), enums e regras m�nimas. Aqui est�o classes como `BaseModel`, `BaseInstrument`, `SafetyValve`, `PressureGauge`, `WorkOrder`, `Report`, `Plan`, `User`, `Customer`.
- `LaudoProUnitTest` � testes unit�rios (ex.: `UserServiceTest`) para comportamentos da aplica��o.

Tecnologias e vers�es
- .NET 9 e .NET 8 (alguns projetos podem targetear net8.0; ver `*.csproj`).
- C# 13, Nullable enabled e ImplicitUsings em projetos que aplicam essas configura��es.
- EF Core para mapeamento ORM e migrations.
- Conven��es: colunas em snake_case via `[Column("...")]`, valida��es com `[Required]`, `[MaxLength]` e �ndices via `[Index]` ou Fluent API.

Como rodar localmente
1. Restaurar depend�ncias e build:
   - `dotnet restore`
   - `dotnet build`
2. Configurar string de conex�o no projeto `LaudoPro.API` (appsettings).
3. Aplicar migrations (execute a partir do projeto de infraestrutura ou usando o startup correto):
   - __Package Manager Console__: `__Add-Migration__ <Name>` e depois `__Update-Database__`
   - CLI exemplo:
     - `dotnet ef migrations add <Name> --project LaudoPro.Infrastructure --startup-project LaudoPro.API`
     - `dotnet ef database update --project LaudoPro.Infrastructure --startup-project LaudoPro.API`
4. Executar API:
   - `dotnet run --project LaudoPro.API`

Principais conven��es do projeto
- Modelos s�o POCOs; l�gica de dom�nio leve fica em servi�os.
- `BaseModel` fornece `Uuid`, `CreatedAt` (imut�vel via configura��o EF) e `UpdatedAt`.
- Instrumentos usam `BaseInstrument` para campos comuns (`Description`, `Tag`, `Manufacturer`, `SerialNumber`, `Model`, `Size`).
- `WorkOrder.Number` pode ser gerado no formato `WO-<8char-UUID>-<yyyyMMdd>`.
- Use `[Index(nameof(Tag), IsUnique = true)]` ou Fluent API para �ndices �nicos e evitar duplicidade de `Tag`.

Boas pr�ticas antes de aplicar migra��es
- Verifique dados existentes que possam violar novas constraints (ex.: duplicatas em `Tag`).
- Teste migrations em ambiente de desenvolvimento antes de aplicar em produ��o.

Contribui��o
- Siga a estrutura de pastas e conven��es de nomes.
- Crie migrations no projeto `LaudoPro.Infrastructure`.
- Adicione testes unit�rios para novas regras de neg�cio.
- Fa�a PRs pequenos e descreva claramente a altera��o.
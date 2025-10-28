dotnet ef migrations add First --startup-project ../LaudoPro.API --output-dir Migrations

dotnet ef database update --startup-project ../LaudoPro.API
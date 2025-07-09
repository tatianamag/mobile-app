using System.Net;
using System.Net.Mail;
using System.Threading.Tasks;

namespace ApiCentroSalud.Helpers
{
    public class EmailSender
    {
        public static async Task SendEmailAsync(string to, string subject, string body)
        {
            var fromAddress = new MailAddress("tu-email@gmail.com", "Centro de Salud");
            var toAddress = new MailAddress(to);
            const string fromPassword = "tu-contraseña";

            var smtp = new SmtpClient
            {
                Host = "smtp.gmail.com",
                Port = 587,
                EnableSsl = true,
                DeliveryMethod = SmtpDeliveryMethod.Network,
                Credentials = new NetworkCredential(fromAddress.Address, fromPassword),
                Timeout = 30000
            };

            var message = new MailMessage(fromAddress, toAddress)
            {
                Subject = subject,
                Body = body
            };

            await smtp.SendMailAsync(message);
        }
    }
}

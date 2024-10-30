import pandas as pd
import smtplib
from email.mime.text import MIMEText

def send_email(recipient, subject, body):
    sender = "your_email@example.com"
    password = "your_email_password"
    
    message = MIMEText(body)
    message["From"] = sender
    message["To"] = recipient
    message["Subject"] = subject

    with smtplib.SMTP("smtp.gmail.com", 587) as server:
        server.starttls()
        server.login(sender, password)
        server.sendmail(sender, recipient, message.as_string())

def track_attendance(file_path):
    df = pd.read_excel(file_path)
    for _, row in df.iterrows():
        if row['Leaves'] == 2:
            send_email(row['Email'], "Attendance Reminder", "You have 1 leave remaining.")
        elif row['Leaves'] >= 3:
            send_email(row['Email'], "Attendance Alert", "You have exceeded the leave limit.")
            send_email("staff_email@example.com", "Student Attendance Alert", f"{row['Name']} has exceeded their leave limit.")

# Assuming the Excel file has columns: Name, Email, Subject, Leaves
track_attendance("attendance.xlsx")

<%@ page import="java.util.List" %>
<%@ page import="travel.Contacts" %>
<%
    List<Contacts> contacts = (List<Contacts>) request.getAttribute("contacts");
    String error = (String) request.getAttribute("error");
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Edit Booking - Admin</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
  
  <style>
    body {
      font-family: 'Poppins', sans-serif;
      background: #f0f2f5;
      margin: 0;
    }

    /* Sidebar */
    .sidebar {
      position: fixed;
      top: 60px; /* Leave space for top navbar */
      left: 0;
      width: 220px;
      height: calc(100% - 60px);
      background: #FFD600; /* User theme color */
      color: #fff;
      padding-top: 20px;
    }
    .sidebar h3 {
      text-align: center;
      margin-bottom: 30px;
      font-size: 1.5rem;
      font-weight: 600;
    }

    .sidebar a {
      display: block;
      color: #fff;
      padding: 15px 25px;
      text-decoration: none;
      font-weight: 500;
      border-left: 4px solid transparent;
      transition: all 0.3s;
    }
    .sidebar a:hover {
      background: #f5ff2e;
      border-left: 4px solid #ffffff;
      
    }

    .sn:hover{
        color: black;
    }


    /* Top Navbar */
    .top-nav {
      position: fixed;
      top: 0;
      left: 0;
      width: 100%;
      height: 60px;
      background: #fff;
      display: flex;
      justify-content: flex-end;
      align-items: center;
      padding: 0 30px;
      box-shadow: 0 2px 8px rgba(0,0,0,0.1);
      z-index: 1000;
    }
    .top-nav img {
      width: 40px;
      height: 40px;
      border-radius: 50%;
      cursor: pointer;
      border: 2px solid #004aad;
    }

   .main-content {
  margin-left: 220px;
  margin-top: 70px;
  padding: 20px;
}

/* Table Styling */
.table {
  background: #fff;
  border-radius: 8px;
  overflow: hidden;
  box-shadow: 0 4px 12px rgba(0,0,0,0.05);
}
.table thead {
  background: #004aad;
  color: #fff;
}
.table tbody tr:hover {
  background: #f1f7ff;
  transition: 0.2s;
}

/* Responsive */
@media(max-width: 768px) {
  .sidebar { width: 180px; }
  .main-content { margin-left: 180px; }
}
.container {
  margin-left: 220px; /* same as sidebar width */
}
}
  </style>
</head>
<body>

  <!-- Top Navbar -->
  <a href="adminprofile.html" class="top-nav">
    <img src="https://cdn-icons-png.flaticon.com/512/149/149071.png" alt="Profile">
  </a>

  <!-- Sidebar -->
  <div class="sidebar">
    <h3>Admin</h3>
    <a class="sn" href="add.html"><i class="fas fa-plus"></i> Book Package</a>
<a class="sn" href="Viewbooking"><i class="fas fa-file-alt"></i> View Bookings</a>
<a class="sn" href="Query"><i class="fas fa-question-circle"></i> User Queries</a>
<a class="sn" href="Contacted"><i class="fas fa-phone"></i> Contacted Users</a>
  </div>


<div class="main-content container mt-5">
        <h2 class="mb-4">📞 Contacted Users</h2>

        <% if (error != null) { %>
          <div class="alert alert-danger"><%= error %></div>
        <% } %>

        <div class="table-responsive">
            <table class="table table-bordered table-striped">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>User ID</th>
                        <th>Full Name</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Message</th>
                        <th>Created At</th>
                    </tr>
                </thead>
                <tbody>
    <% if (contacts != null && !contacts.isEmpty()) {
           for (Contacts c : contacts) { %>
        <tr>
            <td><%= c.getContactId() %></td>
            <td><%= c.getUserId() %></td>
            <td><%= c.getFullName() %></td>
            <td><%= c.getEmail() %></td>
            <td><%= c.getPhone() %></td>
            <td><%= c.getMessage() %></td>
            <td><%= c.getCreatedAt() %></td>
        </tr>
    <% } 
       } else { %>
        <tr><td colspan="7">No contacted users found.</td></tr>
    <% } %>
</tbody>
            </table>
        </div>
    </div>
  

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

<%@ page import="java.util.*, travel.UserQuery" %>
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

    /* Main Content
    .main-content {
      margin-left: 220px;
      margin-top: 60px;
      padding: 30px;
    }
    .main-content h2 {
      margin-bottom: 15px;
      color: #004aad;
    }
    .main-content p {
      color: #333;
      font-size: 1rem;
    }

    @media(max-width: 768px) {
      .sidebar { width: 180px; }
      .main-content { margin-left: 180px; padding: 20px; }
    } */

    .main-content {
  margin-left: 220px;   /* push right to avoid sidebar */
  margin-top: 60px;     /* push down to avoid top navbar */
  padding: 30px;
  max-width: calc(100% - 240px); /* ensures content doesn’t go behind sidebar */
}

.card {
  border-radius: 12px;
  box-shadow: 0 6px 18px rgba(0,0,0,0.1);
  background: #fff;
  padding: 25px;
  margin-bottom: 30px;
}

/* Ensure form fields stretch correctly */
.form-control,
.form-select,
textarea {
  width: 100%;
  border-radius: 8px;
  padding: 10px;
}

/* Responsive */
@media(max-width: 768px) {
  .sidebar { width: 180px; }
  .main-content { 
    margin-left: 180px; 
    max-width: calc(100% - 200px);
    padding: 20px; 
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
  <h2> User Queries</h2>
    <div class="table-responsive">
    <table class="table table-bordered table-striped">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>City</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Destination</th>
                <th>Travel Date</th>
                <th>People</th>
                <th>Vacation Type</th>
                <th>Enquiry Date</th>
            </tr>
        </thead>
        <tbody>
        <%
            List<UserQuery> UserQuery = (List<UserQuery>) request.getAttribute("UserQuery");
            if (UserQuery != null && !UserQuery.isEmpty()) {
                for (UserQuery q : UserQuery) {
        %>
            <tr>
                <td><%= q.getEnquiryId() %></td>
                <td><%= q.getName() %></td>
                <td><%= q.getCity() %></td>
                <td><%= q.getEmail() %></td>
                <td><%= q.getPhone() %></td>
                <td><%= q.getTravelDestination() %></td>
                <td><%= q.getTravelDate() %></td>
                <td><%= q.getNumberOfPeople() %></td>
                <td><%= q.getVacationType() %></td>
                <td><%= q.getEnquiryDate() %></td>
            </tr>
        <%      }
            } else { %>
            <tr><td colspan="10">No queries found.</td></tr>
        <% } %>
        </tbody>
    </table>
    </div>
    </div>

  <!-- Main Content -->

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="travel.Bookings" %>

<%
    List<Bookings> bookings = (List<Bookings>) request.getAttribute("bookings");
    String error = (String) request.getAttribute("error");
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>TravelGo — Explore the world</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="index.css">
</head>
<body data-page="index">
  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm">
  <div class="container">
     <a href="index.html"><img src="assets/logo.png" alt="TravelGo" width="100" class="me-2"></a>

    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbars"
      aria-controls="navbars" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse justify-content-end " id="navbars">
      <ul class="navbar-nav mb-2 mb-lg-0 gap-3">
        <li class="nav-item"><a class="nav-link" href="home.html">Home</a></li>
        <li class="nav-item"><a class="nav-link" href="destinations.html">Destinations</a></li>
        <li class="nav-item"><a class="nav-link" href="Mybooking">My Bookings</a></li>
        <li class="nav-item"><a class="nav-link" href="About.html">About us</a></li>
      </ul>
      <a href="profile.jsp" class="ms-3">
        <img src="https://cdn-icons-png.flaticon.com/512/149/149071.png" alt="Profile"
          class="rounded-circle " width="35" height="35">
      </a>
    </div>
  </div>
</nav>

<div class="container mt-5">

  <h2 class="mb-4 text-warning"> My Bookings</h2>

  <% if (error != null) { %>
    <div class="alert alert-danger"><%= error %></div>
  <% } %>

  <div class="table-responsive">
    <table class="table table-striped table-bordered">
      <thead class="table-dark">
        <tr>
          <th>Booking ID</th>
          <th>Package</th>
          <th>Travel Date</th>
          <th>Adults</th>
          <th>Children</th>
          <th>Total Price</th>
          <th>Status</th>
        </tr>
      </thead>
      <tbody>
      <%
        if (bookings != null && !bookings.isEmpty()) {
            for (Bookings b : bookings) {
      %>
        <tr>
          <td><%= b.getBookingId() %></td>
          <td><%= b.getPackageName() %></td>
          <td><%= b.getTravelDate() %></td>
          <td><%= b.getAdults() %></td>
          <td><%= b.getChildren() %></td>
          <td><%= b.getTotalPrice() %></td>
          <td><%= b.getBookingType() %></td>
        </tr>
      <%
            }
        } else {
      %>
        <tr><td colspan="7">No bookings found.</td></tr>
      <% } %>
      </tbody>
    </table>
  </div>

</div>

<br><br><br>
<footer style="position:fixed; bottom:0px; width:100%" class="bg-dark text-light pt-5 pb-3 mt-auto">
  <div class="container">
    <div class="row g-4">
      
      <!-- Brand Info -->
      <div class="col-md-6 col-lg-4">
        <h4 class="fw-bold text-warning">TravelGo</h4>
        <p class="small">
          Your trusted companion for hassle-free travel planning. Explore, book, and enjoy unforgettable journeys with ease.
        </p>
        <p class="small mb-0">© <span id="year"></span> TravelGo Pvt Ltd. All rights reserved.</p>
      </div>

      <!-- Quick Links -->
      <div class="col-md-6 col-lg-2">
        <h6 class="fw-bold mb-3">Quick Links</h6>
        <ul class="list-unstyled">
          <li><a style="text-decoration:none; color:#bbb;" href="destinations.html" class="footer-link">Destinations</a></li>
          <li><a style="text-decoration:none; color:#bbb;" href="terms.html" class="footer-link">Terms & Conditions</a></li>
          <li><a style="text-decoration:none; color:#bbb;" href="privacy.html" class="footer-link">Privacy Policy</a></li>
          <li><a style="text-decoration:none; color:#bbb;" href="contact.html" class="footer-link">Contact Us</a></li>
          <li><a style="text-decoration:none; color:#bbb;" href="About.html" class="footer-link">About Us</a></li>
        </ul>
      </div>

      <!-- Social Media -->
      <div class="col-md-12 col-lg-4 text-lg-end">
        <h6 class="fw-bold mb-3">Connect with Us</h6>
        <a href="#" class="btn btn-outline-light btn-sm rounded-circle me-2">
          <i class="bi bi-facebook"></i>
        </a>
        <a href="#" class="btn btn-outline-light btn-sm rounded-circle me-2">
          <i class="bi bi-twitter"></i>
        </a>
        <a href="#" class="btn btn-outline-light btn-sm rounded-circle me-2">
          <i class="bi bi-instagram"></i>
        </a>
        <a href="#" class="btn btn-outline-light btn-sm rounded-circle">
          <i class="bi bi-youtube"></i>
        </a>
      </div>

    </div>
  </div>
</footer>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="assets/script.js"></script>
  <script>document.getElementById('year').textContent = new Date().getFullYear();</script>
</body>
</html>

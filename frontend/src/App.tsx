import { Toaster } from "react-hot-toast"
import { BrowserRouter, Route, Routes } from "react-router-dom";
import CustomerLayout from "./pages/customer/layouts/CustomerLayout";
import Home from "./pages/customer/Home";
import Movies from "./pages/customer/movie/Movies";
import AdminLayout from "./pages/admin/layouts/AdminLayout";
import Dashboard from "./pages/admin/Dashboard";
import Member from "./pages/customer/Member";
import MovieDetails from "./pages/customer/movie/MovieDetails";
import Auth from "./pages/customer/Auth";
import NotFound from "./pages/NotFound";

function App() {

  return (
    <>
      <Toaster position="top-center" reverseOrder={false}/>
      <BrowserRouter>
        <Routes>
          {/* Customer Routes */}
          <Route path="/" element={<CustomerLayout/>}>
            <Route index element={<Home/>}/>
            <Route path="/phim" element={<Movies/>}/>
            <Route path="/chi-tiet-phim/:movieId" element={<MovieDetails/>}/>
            <Route path="/thanh-vien" element={<Member/>}/>
            <Route path="/login" element={<Auth/>}/>
          </Route>
          {/* Admin Routes */}
          <Route path="/" element={<AdminLayout/>}>
            <Route path="/admin" element={<Dashboard/>}/>
            <Route path="/admin/movies" element={<Movies/>}/>
            <Route path="/admin/users" element={<Movies/>}/>
          </Route>
          {/* Not found */}
          <Route path="*" element={<NotFound />}/>
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App;

import toast, { Toaster } from "react-hot-toast"
import Login from "./pages/auth/Login"
import Register from "./pages/auth/Register"

function App() {

  const notify = () => toast("This is your toast", {
    icon: '🐳'
  });

  return (
    <>
      <Toaster position="top-center" reverseOrder={false}/>
      <div className="p-5">
        <Login/>
        <span className="mx-1"></span>
        <Register/>
        <button className="btn btn-secondary ms-2" onClick={notify}>Show toast</button>
      </div>
    </>
  )
}

export default App;
